package utils;

import java.util.Properties;

public class ReadConfig {
        private static Properties properties;

    public static String get(String key){
        if (properties==null) {
            properties = ReadProperty.loadProperties("src/test/java/Pages/config.properties");
            return properties.getProperty(key);
        }
        return properties.getProperty(key);
    }
}
