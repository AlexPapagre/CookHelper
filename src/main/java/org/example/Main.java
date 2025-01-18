package org.example;

public class Main {

    // Logger initialization
    private static final Logger logger = new ConsoleLogger();
    private static final Logger logErr = new ErrorLogger();

    public static void main(String[] args) {

        // Check if user provided arguments
        if (args.length > 0) {

            // Terminal
            if (args[0].equalsIgnoreCase("-term")) {

                // Searching for people
                int people;
                String[] files;
                try {
                    people = Integer.parseInt(args[args.length - 1]);
                    files = new String[args.length - 2];
                    System.arraycopy(args, 1, files, 0, args.length - 2);
                } catch (NumberFormatException e) {
                    people = 1;
                    files = new String[args.length - 1];
                    System.arraycopy(args, 1, files, 0, args.length - 1);
                }

                // Check for files
                if (files.length < 1) {
                    logErr.log("No files provided!");
                    Exit.error();
                }

                if (files.length == 1) { // One file

                    // Get fileName
                    String fileName = files[0];

                    // Check if argument is "-list"
                    if (fileName.equals("-list")) {
                        logErr.log("For lists you can type \"-list\" followed by one or more files to display a list!");
                        Exit.error();
                    }

                    // Check if file is ".cook"
                    if (!fileName.endsWith(".cook")) {
                        logErr.log("File \"" + fileName + "\" is not a \".cook\" file!");
                        Exit.error();
                    }

                    // Create recipe
                    Recipe recipe = new RecipeImpl(fileName, people);

                    // Print recipe
                    logger.log(recipe.getRecipe());

                    // Exit program
                    System.exit(0);

                } else { // List of files

                    // Check if first argument isn't "-list"
                    if (!files[0].equals("-list")) {
                        logErr.log("For multiple arguments you can type \"-list\" followed by one or more files to display a list!");
                        Exit.error();
                    }

                    // Create recipe list
                    RecipeList recipes = new RecipeListImpl();

                    // Getting all recipes
                    for (int i = 1; i < files.length; i++) {

                        // Get fileName
                        String fileName = files[i];

                        // Check if file is ".cook"
                        if (!fileName.endsWith(".cook")) {
                            logErr.log("File \"" + fileName + "\" is not a \".cook\" file!");
                            Exit.error();
                        }

                        // Create recipe
                        recipes.add(new RecipeImpl(fileName, people));
                    }

                    // Make list
                    recipes.makeList();

                    // Print list
                    logger.log(recipes.getList());

                    // Exit program
                    System.exit(0);

                }
            }
        }

        // GUI
        MainMenuView mainMenuView = new MainMenuView(new MainMenuFiles(args));
        mainMenuView.display();
    }
}
