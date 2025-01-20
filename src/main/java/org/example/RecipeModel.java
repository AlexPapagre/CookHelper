package org.example;

public abstract class RecipeModel {
    private final int people;
    private final String fileName;
    private final Recipe recipe;

    public RecipeModel(String file, int people) {
        this.people = people;

        fileName = Convertor.convertFileName(file);

        recipe = new RecipeImpl(Convertor.convertFilePath(file), people);
    }

    public int getPeople() {
        return people;
    }

    public String getFileName() {
        return "'" + fileName + "'";
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
