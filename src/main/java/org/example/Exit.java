package org.example;

import static org.example.Main.logErr;

public class Exit {

    public static void error(String message) {
        exit(message + "\n");
    }

    public static void errorGuide(String message) {
        exit(message + "\n" +
                "Usage 1 (Information): java -jar target/CookHelper-1.0-SNAPSHOT.jar recipe.cook\n" +
                "Usage 2 (Supermarket list): java -jar target/CookHelper-1.0-SNAPSHOT.jar -list recipe1.cook recipe2.cook ... recipeN.cook\n\n" +
                "For multiple people you can type the amount of people at the end of the line (after usage 1 or usage 2).\n" +
                "e.g for 3 people\n" +
                "... recipe.cook \n"
        );
    }

    private static void exit(String message) {
        logErr.log(message + "Exiting program!");
        System.exit(1);
    }
}
