package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("properties/config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties file not found in resources folder");
            }

            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load config.properties", ex);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getUrl() {
        return get("url");
    }

    public static String getEmail() {
        return get("email");
    }

    public static String getPassword() {
        return get("password");
    }

}
