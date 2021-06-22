package com.learn;

import java.io.File;

public class RenamableFile {
    File file;

    public RenamableFile(String nameFile) {
        this.file = new File(nameFile);
    }

    public String appendSuffix(String suffix) {

        String fileName = this.file.getName();
        String filenameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
        String extension = fileName.substring(fileName.lastIndexOf('.'));
        String newNameWithSuffix = String.format("%s_%s%s", filenameWithoutExtension, suffix, extension);

        this.file.renameTo(new File(newNameWithSuffix));
        return newNameWithSuffix;
    }
}

