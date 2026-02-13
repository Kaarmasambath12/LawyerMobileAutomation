package config;

import constants.FrameworkConstants;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    public static Properties prop;


    public ReadConfig(){

        prop = new Properties();
        try {
            File file = new File(FrameworkConstants.getPropertyFilePath());
            FileInputStream fileInputStream = new FileInputStream(file);
            prop.load(fileInputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
