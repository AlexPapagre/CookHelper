package org.example;

public class RecipeModel {
    private final int people;
    private final String name;
    private final Recipe recipe;

    public RecipeModel(String file, int people) {
        this.people = people;

        // Split to file name and file path
        String[] parts = file.split(" --> \\(");
        name = parts[0];
        String filePath = parts[1].replace(")", "");

        recipe = new RecipeImpl(filePath, people);
    }

    public String displayRecipe() {
        return "Συνταγή: '" + name + "' για " + people + " " + (people == 1 ? "άτομο" : "άτομα") + "\n\n" + recipe.getRecipe();
    }

    public String executeRecipeStart() {
        return "Εκτέλεση: '" + name + "' για " + people + " " + (people == 1 ? "άτομο" : "άτομα");
    }
}
