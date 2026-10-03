package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OTPUtility {

    // Method 1: Get OTP from Database
    public static String getOTPFromDatabase(String mobileNumber, String dbUrl, String dbUsername, String dbPassword) throws Exception {
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            String query = "SELECT otp FROM otp_table WHERE mobile_number = '" + mobileNumber + "' ORDER BY created_at DESC LIMIT 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                String otp = rs.getString("otp");
                conn.close();
                return otp;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error retrieving OTP from database: " + e.getMessage());
        }
        return null;
    }

    // Method 2: Get OTP from Log File
    public static String getOTPFromLogFile(String logFilePath, String mobileNumber) {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(logFilePath);
            String content = new String(java.nio.file.Files.readAllBytes(path));

            // Pattern to find OTP (adjust regex based on your log format)
            Pattern pattern = Pattern.compile("OTP for " + mobileNumber + ": (\\d{6})");
            Matcher matcher = pattern.matcher(content);

            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving OTP from log file: " + e.getMessage());
        }
        return null;
    }

    // Method 3: Get OTP from SMS via ADB (Android)
    public static String getOTPFromSMS(String mobileNumber) throws Exception {
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"adb", "shell",
                "content", "query", "--uri", "content://sms",
                "--where", "address='" + mobileNumber + "'",
                "--sort", "_id DESC", "--limit", "1"});

            java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                // Extract OTP from SMS body (adjust pattern as needed)
                Pattern pattern = Pattern.compile("\\b(\\d{6})\\b");
                Matcher matcher = pattern.matcher(line);

                if (matcher.find()) {
                    return matcher.group(1);
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving OTP from SMS: " + e.getMessage());
        }
        return null;
    }

    // Method 4: Get OTP from Email (using JavaMail API)
    // Note: Commented out as it requires javax.mail dependency
    public static String getOTPFromEmail(String emailAddress, String emailPassword, String imapServer) {
        System.out.println("Email OTP retrieval not enabled. Please use DATABASE, SMS, API, or LOG_FILE sources.");
        return null;
    }

    // Method 5: Get OTP from Test Data Provider / Configuration
    public static String getOTPFromConfig(String mobileNumber) {
        // Store test OTPs in a properties file or environment variable
        try {
            String otpMap = System.getProperty("test.otp." + mobileNumber);
            if (otpMap != null) {
                return otpMap;
            }
        } catch (Exception e) {
            System.out.println("Error retrieving OTP from config: " + e.getMessage());
        }
        return null;
    }

    // Method 6: Get OTP from REST API
    public static String getOTPFromAPI(String mobileNumber, String apiUrl, String apiToken) throws Exception {
        try {
            java.net.URL url = new java.net.URL(apiUrl + "?mobile=" + mobileNumber);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + apiToken);

            java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse JSON response to extract OTP
            // Using regex for simple extraction
            Pattern pattern = Pattern.compile("\"otp\":\\s*\"(\\d{6})\"");
            Matcher matcher = pattern.matcher(response.toString());

            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving OTP from API: " + e.getMessage());
        }
        return null;
    }

    // Method 7: Wait for OTP and Retry
    public static String getOTPWithRetry(String mobileNumber, OTPSource source, int maxRetries, int delaySeconds) throws Exception {
        String otp = null;
        int attempts = 0;

        while (otp == null && attempts < maxRetries) {
            otp = getOTP(mobileNumber, source);

            if (otp == null) {
                attempts++;
                if (attempts < maxRetries) {
                    System.out.println("OTP not found. Retrying... (Attempt " + attempts + "/" + maxRetries + ")");
                    Thread.sleep(delaySeconds * 1000);
                }
            }
        }

        if (otp == null) {
            throw new Exception("Failed to retrieve OTP after " + maxRetries + " attempts");
        }

        return otp;
    }

    // Main method to get OTP based on source
    public static String getOTP(String mobileNumber, OTPSource source) throws Exception {
        switch (source) {
            case DATABASE:
                return getOTPFromDatabase(mobileNumber,
                    System.getProperty("db.url"),
                    System.getProperty("db.username"),
                    System.getProperty("db.password"));

            case LOG_FILE:
                return getOTPFromLogFile(System.getProperty("log.file.path"), mobileNumber);

            case SMS:
                return getOTPFromSMS(mobileNumber);

            case EMAIL:
                return getOTPFromEmail(
                    System.getProperty("email.address"),
                    System.getProperty("email.password"),
                    System.getProperty("email.imap.server"));

            case CONFIG:
                return getOTPFromConfig(mobileNumber);

            case API:
                return getOTPFromAPI(
                    mobileNumber,
                    System.getProperty("otp.api.url"),
                    System.getProperty("otp.api.token"));

            default:
                return null;
        }
    }

    // Enum for OTP sources
    public enum OTPSource {
        DATABASE,
        LOG_FILE,
        SMS,
        EMAIL,
        CONFIG,
        API
    }
}