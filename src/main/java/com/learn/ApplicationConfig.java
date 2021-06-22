package com.learn;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ApplicationConfig {
    Properties properties;

    public ApplicationConfig(String propertiesFileName) {
        this.properties = loadProperties(propertiesFileName);
    }

    protected Properties loadProperties(String propertiesFileName) {
        Properties properties = new Properties();
        try (InputStream is =  this.getClass().getClassLoader().getResourceAsStream(propertiesFileName)) {
            properties.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String getSuffix() {
        return this.properties.getProperty("suffix");
    }

    public List<String> getFileNames() {

        String[] array = this.properties.getProperty("fileNames").split(",");

        return Arrays.asList(array);
    }

}
