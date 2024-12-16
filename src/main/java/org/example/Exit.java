package org.example;

public class Exit {
    public static void error() {
        Logger logErr = new ErrorLogger();

        logErr.log("\nUsage 1 (Information): java -jar target/CookHelper-1.0-SNAPSHOT.jar recipe.cook");
        logErr.log("Usage 2 (Supermarket list): java -jar target/CookHelper-1.0-SNAPSHOT.jar -list recipe1.cook recipe2.cook ... recipeN.cook");
        logErr.log("\nFor multiple people you can type the amount of people at the end of the line (after usage 1 or usage 2).");
        logErr.log("e.g for 3 people");
        logErr.log("... recipe.cook 3");
        logErr.log("\nExiting program!");
        System.exit(1);
    }
}
