package org.example;

public class DisplayRecipeModel extends RecipeModel {

    public DisplayRecipeModel(String file, int people) {
        super(file, people);
    }

    public String displayRecipe() {
        return "Συνταγή: " + getFileName() + " για " + getPeople() + " " + (getPeople() == 1 ? "άτομο" : "άτομα") + "\n\n" + getRecipe().getRecipe();
    }
}
