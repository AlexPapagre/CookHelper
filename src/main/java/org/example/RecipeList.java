package org.example;

public interface RecipeList {

    // Adds a recipe to the list
    void add(Recipe recipe);

    // Makes a list of the added recipes
    void makeList();

    // Returns the created list
    String getList();

}
