package com.learn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {
    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        log.info("Class.Application started");
        ApplicationConfig applicationConfig = new ApplicationConfig("application.properties");
        log.info("read application properties");
        String suffix = applicationConfig.getSuffix();

        for (String nameFile : applicationConfig.getFileNames()) {

            RenamableFile renamableFile = new RenamableFile(nameFile);
            String newNameFile = renamableFile.appendSuffix(suffix);

            log.info(String.format("%s->%s", nameFile, newNameFile));
        }
        log.info("the end of the application");
    }
}
