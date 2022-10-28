package base2.mantis.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {
    private static Map<String, Properties> cachedProperties = new HashMap<>();

    public static Properties load(String page) {
        if (cachedProperties.get(page) != null) {
            return cachedProperties.get(page);
        }

        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = loader.getResourceAsStream(page + ".properties");

        if (inputStream != null) {
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        cachedProperties.put(page, properties);

        return properties;
    }

    public static Properties loadGlobal() {
        return load("globalParameters");
    }
}
