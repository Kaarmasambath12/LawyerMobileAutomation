package helper;


import Device.DriverThreadManager;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class VideoRecorderUtil {

    public static void startRecording() {

            AndroidDriver driver =
                    (AndroidDriver) DriverThreadManager.getDriver();

            if (driver != null) {
                driver.startRecordingScreen();
            }
        }

        public static void stopRecording(String testName) {

            AndroidDriver driver =
                    (AndroidDriver) DriverThreadManager.getDriver();

            if (driver == null) return;

            String base64Video = driver.stopRecordingScreen();

            if (base64Video == null || base64Video.isEmpty()) return;

            byte[] decodedVideo = Base64.getDecoder().decode(base64Video);

            String videoPath = System.getProperty("user.dir")
                    + File.separator + "videos"
                    + File.separator + testName + ".mp4";

            try {
                File videoFile = new File(videoPath);
                videoFile.getParentFile().mkdirs();

                FileOutputStream stream = new FileOutputStream(videoFile);
                stream.write(decodedVideo);
                stream.close();

                System.out.println("Video saved at: " + videoPath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }