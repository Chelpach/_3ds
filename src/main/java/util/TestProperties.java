package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by user on 12.09.2017.
 */
public class TestProperties {

    private final Properties properties = new Properties();

    private static util.TestProperties INSTANCE = null;

    private TestProperties() {
        try {
            properties.load(new FileInputStream(new File("./" + System.getProperty("environment") + ".properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static util.TestProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new util.TestProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }

}

