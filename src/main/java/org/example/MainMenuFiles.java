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
            if (file.exists()) {
                if (file.getName().endsWith(".cook")) {
                    addFile(file);
                } else {
                    logErr.log("File '" + file.getName() + "' is not a '.cook' file!");
                }
            } else {
                logErr.log("File '" + arg + "' doesn't exist!");
            }
        }
    }

    private void addFile(File file) {
        files.add(file.getName().replace(".cook", "") + " --> (" + file.getAbsolutePath() + ")");
    }

    public Iterator<String> filesIterator() {
        return files.listIterator();
    }
}
