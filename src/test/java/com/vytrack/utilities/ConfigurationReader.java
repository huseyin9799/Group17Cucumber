package com.vytrack.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static final Properties properties = new Properties();

    static {
        try {
            InputStream in = new FileInputStream("configuration.properties");
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load properties file!");
        }
    }

    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }
}
