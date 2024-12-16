package org.example;

/**
 * A recipe list interface
 */
public interface RecipeList {

    /**
     * Add recipe.
     *
     * @param recipe the recipe to add to the list
     */
    void add(Recipe recipe);

    /**
     * Make a list of the added recipes.
     */
    void makeList();

    /**
     * Returns list.
     *
     * @return str the created list
     */
    String getList();

}
