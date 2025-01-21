package org.example;

public class Main {

    // Logger initialization
    public static final Logger logger = LoggerFactory.getInstance().getLogger("console");
    public static final Logger logErr = LoggerFactory.getInstance().getLogger("error");

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
                    Exit.errorGuide("No files provided!");
                }

                if (files.length == 1) { // One file

                    // Get fileName
                    String fileName = files[0];

                    // Check if argument is '-list'
                    if (fileName.equals("-list")) {
                        Exit.errorGuide("For lists you can use the '-term -list' modifiers followed by one or more files to display a list!");
                    }

                    // Check if file is .cook file
                    if (!fileName.endsWith(".cook")) {
                        Exit.errorGuide("File '" + fileName + "' is not a '.cook' file!");
                    }

                    // Create recipe
                    Recipe recipe = new RecipeImpl(fileName, people);

                    // Print recipe
                    logger.log(recipe.getRecipe());

                    // Exit program
                    System.exit(0);

                } else { // List of files

                    // Check if first argument isn't '-list'
                    if (!files[0].equals("-list")) {
                        if (files[0].startsWith("-")) {
                            Exit.errorGuide("'" + files[0] + "' is not a modifier!");
                        } else {
                            Exit.errorGuide("For multiple arguments you can use the '-term -list' modifiers followed by one or more files to display a list!");
                        }
                    }

                    // Create recipe list
                    RecipeList recipes = new RecipeListImpl();

                    // Getting all recipes
                    for (int i = 1; i < files.length; i++) {

                        // Get fileName
                        String fileName = files[i];

                        // Check if file is .cook file
                        if (!fileName.endsWith(".cook")) {
                            Exit.errorGuide("File '" + fileName + "' is not a '.cook' file!");
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
            } else if (args[0].startsWith("-")) {
                Exit.errorGuide("'" + args[0] + "' is not a modifier!");
            }
        }

        // Main Menu
        logger.log("Opening GUI");
        new MainMenuView(new MainMenuFiles(args));
    }
}
