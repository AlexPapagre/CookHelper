package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeImpl implements Recipe {
    private final List<Step> steps;
    private final Map<String, IngredientByMeasure> ingredients;
    private final Map<String, Integer> utensils;
    private final Time times;

    public RecipeImpl(String fileName, int people) {
        StepReader in = new StepReaderImpl(people);
        this.steps = in.parseSteps(fileName);
        this.ingredients = putIngredients();
        this.utensils = putUtensils();
        this.times = putTimes();
    }

    @Override
    public List<Step> getSteps() {
        return steps;
    }

    @Override
    public String getRecipe() {
        StringBuilder str = new StringBuilder();

        // Ingredients
        str.append("Υλικά:\n");
        for (Map.Entry<String, IngredientByMeasure> entry : ingredients.entrySet()) {
            str.append("  ").append(entry.getKey()).append(entry.getValue().getAmountMeasure()).append("\n");
        }
        str.append("\n");

        // Utensils
        str.append("Σκεύη:\n");
        for (Map.Entry<String, Integer> entry : utensils.entrySet()) {
            str.append("  ");
            str.append(entry.getKey());
            if (entry.getValue() > 1) {
                str.append(" ").append(entry.getValue());
            }
            str.append("\n");
        }
        str.append("\n");

        // Times
        str.append("Συνολική ώρα:\n");
        str.append("  ").append(times.toString()).append("\n");
        str.append("\n");

        // Steps
        str.append("Βήματα:\n");
        int i = 1;
        for (Step step : steps) {
            str.append("  ").append(i).append(". ").append(step.desc()).append("\n\n");

            // Step ingredients
            str.append("  " + "Υλικά βήματος ").append(i).append(": ");
            if (step.ingredients().isEmpty()) {
                str.append(" Δεν υπάρχουν υλικά.");
            } else {
                for (int j = 0; j < step.ingredients().size(); j++) {
                    if (j > 0) {
                        str.append(" και");
                    }
                    str.append(" ").append(step.ingredients().get(j).toString());
                }
            }
            str.append("\n");

            // Step time
            str.append("  Χρόνος βήματος ").append(i).append(": ").append(step.time().toString());

            str.append("\n\n");

            i++;
        }

        return str.toString();
    }

    @Override
    public Step getStep(int i) {
        return steps.get(i);
    }

    private Map<String, IngredientByMeasure> putIngredients() {
        Map<String, IngredientByMeasure> ingredients = new HashMap<>();
        for (Step step : steps) {
            for (Ingredient ingredient : step.ingredients()) {
                if (ingredients.containsKey(ingredient.getName())) {
                    IngredientByMeasure ibm = ingredients.get(ingredient.getName());
                    if (ibm.containsKey(ingredient.getMeasure())) {
                        String key = ingredient.getMeasure();
                        Double value = ibm.get(key) + ingredient.getAmount();
                        ibm.put(key, value);
                    } else {
                        String key = ingredient.getMeasure();
                        Double value = ingredient.getAmount();
                        ibm.put(key, value);
                    }
                } else {
                    ingredients.put(ingredient.getName(), new IngredientByMeasure(ingredient.getMeasure(), ingredient.getAmount()));
                }
            }
        }
        return ingredients;
    }

    private Map<String, Integer> putUtensils() {
        Map<String, Integer> utensils = new HashMap<>();
        for (Step step : steps) {
            for (Utensil utensil : step.utensils()) {
                if (utensils.containsKey(utensil.name())) {
                    String key = utensil.name();
                    Integer value = utensils.get(key) + 1;
                    utensils.put(key, value);
                } else {
                    utensils.put(utensil.name(), 1);
                }
            }
        }
        return utensils;
    }

    private Time putTimes() {
        Time times = new TimeImpl();
        for (Step step : steps) {
            times.addTimes(step.time());
        }
        return times;
    }
}
