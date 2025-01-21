package org.example;

public class UserManual {

    public static String manual() {
        return """
                User manual:
                  This program only accepts .cook files.
                
                    Mode 1 (GUI):
                      Usage 1 (Empty): Opens GUI with no pre-selected files.
                        Run: java -jar target/recipes.jar
                                          or
                             java -jar target/recipes.jar -gui
                
                      Usage 2 (With files): Opens GUI with one or more pre-selected files.
                        Run: java -jar target/recipes.jar -gui recipe1.cook recipe2.cook ... recipeN.cook
                
                    Mode 2 (Terminal):
                      Usage 1 (Display Recipe): Select one recipe and display it.
                        For one person run: java -jar -term target/recipes.jar recipe.cook
                        For multiple people (e.g 3) run: java -jar -term target/recipes.jar recipe.cook 3
                
                      Usage 2 (Shopping list): Select one or more recipes and print a shopping list.
                        For one person run: java -jar target/recipes -term -list recipe1.cook recipe2.cook ... recipeN.cook
                        For multiple people (e.g 3) run: java -jar target/recipes.jar -term -list recipe1.cook recipe2.cook ... recipeN.cook 3
                
                  For further information please check the README and report files.
                """;
    }
}
