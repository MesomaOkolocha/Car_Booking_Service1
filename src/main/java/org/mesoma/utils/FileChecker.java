package org.mesoma.utils;

import java.io.File;
import java.io.IOException;

public class FileChecker {
    public static File createFile(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException();
        }
    }
}
