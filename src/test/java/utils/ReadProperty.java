package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperty {
    public static Properties loadProperties(String path) {
    Properties properties = null;
    try(FileInputStream fis = new FileInputStream(path)) {
        properties = new Properties();
        properties.load(fis);
    } catch (Exception ignored) {

    }
    return properties;
}



}
