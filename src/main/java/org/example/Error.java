package org.example;

import static org.example.Main.logErr;

public class Error {

    public static void exit(String message) {
        logErr.log(message + "\n\nFor user manual run: java -jar target/recipes.jar -help");
        System.exit(1);
    }
}
