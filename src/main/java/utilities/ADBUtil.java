package utilities;

public class ADBUtil {

    public static void tap(int x, int y) {
        try {
            Process process = Runtime.getRuntime().exec(
                    "adb shell input tap " + x + " " + y
            );
            process.waitFor();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void typeText(String text) {
        try {

            // Encode special characters
            text = text.replace("@", "%40")
                    .replace(" ", "%s")
                    .replace("&", "\\&")
                    .replace("(", "\\(")
                    .replace(")", "\\)");

            Process process = Runtime.getRuntime().exec(
                    "adb shell input text " + text
            );

            process.waitFor();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pressEnter() {
        try {
            Runtime.getRuntime()
                    .exec("adb shell input keyevent 66")
                    .waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void pressKeyCode(int keyCode) {
        try {
            Runtime.getRuntime()
                    .exec("adb shell input keyevent " + keyCode)
                    .waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
