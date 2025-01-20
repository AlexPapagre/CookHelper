package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShoppingListModel {
    private final int people;
    private final List<String> names = new LinkedList<>();
    private final List<Recipe> recipes = new LinkedList<>();

    public ShoppingListModel(List<String> files, int people) {
        this.people = people;

        for (String file : files) {

            // Split to file name and file path
            String[] parts = file.split(" --> \\(");
            names.add(parts[0]);
            String filePath = parts[1].replace(")", "");

            recipes.add(new RecipeImpl(filePath, people));
        }
    }

    public int getPeople() {
        return people;
    }

    public String getNames() {
        return Convertor.convertNames(names.listIterator());
    }

    public String shoppingList() {
        StringBuilder str = new StringBuilder();

        str.append("Λίστα σούπερ μάρκετ: ").append(getNames());
        str.append(" για ").append(people).append(" ").append(people == 1 ? "άτομο" : "άτομα").append("\n\n");

        RecipeList recipeList = new RecipeListImpl();
        for (Recipe recipe : recipes) {
            recipeList.add(recipe);
        }
        recipeList.makeList();
        str.append(recipeList.getList());

        return str.toString();
    }
}
