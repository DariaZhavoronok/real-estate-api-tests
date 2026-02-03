import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        final String fileName = "config.properties";
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new RuntimeException("config.properties file not found in resources!");
            }
            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties!", e);
        }
    }

    private static String getPropertyWithFallback(final String key) {
        String systemValue = System.getProperty(key);
        if (systemValue != null) {
            return systemValue;
        }
        return properties.getProperty(key);
    }

    public static String getProtocol() {
        return getPropertyWithFallback("base.protocol");
    }

    public static String getUserAgentHeader(){
        return getPropertyWithFallback("header.agent");
    }
}
