package util;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

@Getter
public class PropertiesUtil {

    private static final Properties properties = new Properties();

    @SneakyThrows
    public static Properties getProperties() {
        FileInputStream propertiesFile = new FileInputStream(
                "application.properties");
        properties.load(propertiesFile);
        return properties;
    }

}
