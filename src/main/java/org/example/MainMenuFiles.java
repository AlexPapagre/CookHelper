package org.example;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainMenuFiles {
    private final List<String> files = new LinkedList<>();

    public MainMenuFiles(String[] args) {
        Logger logErr = new ErrorLogger();

        // Add valid files to menu
        for (String arg : args) {

            File file = new File(arg);

            // Check if file exists
            if (file.exists()) {

                // Check if file is .cook file
                if (file.getName().endsWith(".cook")) {

                    // Check if file is already in the list
                    if (!filesContains(file)) {
                        addFile(file);
                    } else {
                        logErr.log("File '" + file.getName() + "' is already in the list.");
                    }
                } else {
                    logErr.log("File '" + file.getName() + "' is not a '.cook' file!");
                }
            } else {
                logErr.log("File '" + arg + "' doesn't exist!");
            }
        }
    }

    public Iterator<String> filesIterator() {
        return files.listIterator();
    }

    private boolean filesContains(File file) {
        for (String listFile : files) {
            if (convertFile(file).equals(listFile)) {
                return true;
            }
        }
        return false;
    }

    private void addFile(File file) {
        files.add(convertFile(file));
    }

    private String convertFile(File file) {
        return file.getName().replace(".cook", "") + " --> (" + file.getAbsolutePath() + ")";
    }
}
