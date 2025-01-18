package org.example;

public class RecipeModel {
    private final int people;
    private final String name;
    private final RecipeImpl recipe;

    public RecipeModel(String file, int people) {
        this.people = people;

        // Split to file name and file path
        String[] parts = file.split(" --> \\(");
        name = parts[0];
        String filePath = parts[1].replace(")", "");

        recipe = new RecipeImpl(filePath, people);
    }

    public int getPeople() {
        return people;
    }

    public String getName() {
        return name;
    }

    public String displayRecipe() {
        return recipe.getRecipe();
    }
}
