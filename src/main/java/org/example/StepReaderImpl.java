package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static java.nio.charset.StandardCharsets.UTF_8;

public class StepReaderImpl implements StepReader {
    private static final Logger logErr = new ErrorLogger();

    private List<Step> steps;
    private int people;

    public StepReaderImpl(int people) {
        this.steps = new ArrayList<>();
        this.people = people;
    }

    @Override
    public List<Step> parseSteps(String fileName) throws FileNotFoundException {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName, UTF_8));
            String desc = "";
            String step;
            step = in.readLine();
            while (step != null) {
                if (step.isEmpty()) {
                    if (!desc.isEmpty()) {
                        if (!desc.endsWith(",") && !desc.endsWith(".") && !desc.endsWith(";") && !desc.endsWith("?") && !desc.endsWith("!")) {
                            desc += ".";
                        }
                        List<Ingredient> ingredients = new ArrayList<>();
                        List<Utensil> utensils = new ArrayList<>();
                        Time time = findIngredientsUtensilsTimes(ingredients, utensils, desc);
                        steps.add(new Step(desc, ingredients, utensils, time));
                        desc = "";
                    }
                } else {
                    if (desc.isEmpty()) {
                        desc += step;
                    } else {
                        desc += "\n     " + step;
                    }
                }
                step = in.readLine();
            }
            if (!desc.isEmpty()) {
                List<Ingredient> ingredients = new ArrayList<>();
                List<Utensil> utensils = new ArrayList<>();
                Time time = new TimeImpl();
                findIngredientsUtensilsTimes(ingredients, utensils, desc);
                steps.add(new Step(desc, ingredients, utensils, time));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            logErr.log("Error: " + e.getMessage());
            System.exit(1);
        } finally {
            closeQuietly(in);
        }
        return steps;
    }

    private Time findIngredientsUtensilsTimes(List<Ingredient> ingredients, List<Utensil> utensils, String step) {
        Time time = new TimeImpl();
        for (int i = 0; i < step.length(); i++) {

            // Ingredient
            if (step.charAt(i) == '@') {

                // Ingredient name
                int startOfName = i + 1;
                int endOfName = findName(step, startOfName);
                String name = step.substring(startOfName, endOfName);

                // Ingredient amount
                if (step.charAt(endOfName) == '{') {
                    int startOfAmount = endOfName + 1;
                    int endOfAmount = findAmount(step, startOfAmount);
                    double amount = Double.parseDouble(step.substring(startOfAmount, endOfAmount));

                    // Ingredient measure
                    if (step.charAt(endOfAmount) == '%') {
                        int startOfMeasure = endOfAmount + 1;
                        int endOfMeasure = findMeasure(step, startOfMeasure);
                        String measure = step.substring(startOfMeasure, endOfMeasure);

                        // Ingredient creation
                        i = endOfMeasure;
                        ingredients.add(new IngredientImpl(name, amount, measure, people));
                    } else {

                        // Ingredient creation
                        i = endOfAmount;
                        ingredients.add(new IngredientImpl(name, amount, people));
                    }
                } else {

                    // Ingredient creation
                    i = endOfName;
                    ingredients.add(new IngredientImpl(name, people));
                }

            // Utensil
            } else if (step.charAt(i) == '#') {

                // Utensil name
                int startOfName = i + 1;
                int endOfName = findName(step, startOfName);
                String name = step.substring(startOfName, endOfName);

                // Utensil creation
                i = endOfName;
                utensils.add(new UtensilImpl(name));

            // Time
            } else if(step.charAt(i) == '~') {

                // Time amount
                int startOfAmount = i + 2;
                int endOfAmount = findAmount(step, startOfAmount);
                double amount = Double.parseDouble(step.substring(startOfAmount, endOfAmount));

                if (step.charAt(endOfAmount) == '%') {
                    int startOfMeasure = endOfAmount + 1;
                    int endOfMeasure = findMeasure(step, startOfMeasure);
                    String measure = step.substring(startOfMeasure, endOfMeasure);

                    // Time creation
                    i = endOfMeasure;
                   time = new TimeImpl(amount, measure);
                } else {
                    logErr.log("File has no time measure!");
                    Exit.error();
                }
            }
        }
        return time;
    }

    private static int findName(String step, int i) {
        boolean firstSpace = true;
        int endOfName = step.length();
        while (true) {

            // Out of String
            boolean stop = false;
            if (i >= step.length()) { break; }

            switch (step.charAt(i)) {
                case ' ', ',', '.', ';', '?', '!':
                    if (firstSpace) {
                        endOfName = i;
                        firstSpace = false;
                    }
                    break;

                case '{':
                    endOfName = i;
                    stop = true;
                    break;

                case '@', '#', '~':
                    stop = true;
                    break;
            }

            // Name found
            if (stop) { break; }

            i++;
        }
        return endOfName;
    }

    private static int findAmount(String step, int i) {
        int endOfAmount;
        while (true) {
            if (step.charAt(i) == '%' || step.charAt(i) == '}') {
                endOfAmount = i;
                break;
            }
            i++;
        }
        return endOfAmount;
    }

    private static int findMeasure(String step, int i) {
        int endOfMeasure;
        while (true) {
            if (step.charAt(i) == '}') {
                endOfMeasure = i;
                break;
            }
            i++;
        }
        return endOfMeasure;
    }

    private static void closeQuietly(Reader in) {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            logErr.log("Error closing file!");
            System.exit(1);
        }
    }

}
