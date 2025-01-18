package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeListImpl implements RecipeList {
    private final List<Recipe> recipes;
    private Map<String, IngredientByMeasure> ingredients;

    public RecipeListImpl() {
        this.recipes = new ArrayList<>();
    }

    @Override
    public void add(Recipe recipe) {
        recipes.add(recipe);
    }

    @Override
    public void makeList() {
        ingredients = putIngredients();
    }

    @Override
    public String getList() {
        StringBuilder str = new StringBuilder();

        // List
        for (Map.Entry<String, IngredientByMeasure> entry : ingredients.entrySet()) {
            str.append("  ").append(entry.getKey()).append(entry.getValue().getAmountMeasure()).append("\n");
        }

        return str.toString();
    }

    private Map<String, IngredientByMeasure> putIngredients() {
        Map<String, IngredientByMeasure> ingredients = new HashMap<>();
        for (Recipe recipe : recipes) {
            for (Step step : recipe.getSteps()) {
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
        }
        return ingredients;
    }

}
