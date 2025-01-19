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
        return "Εκτέλεση Συνταγής: '" + name + "' για " + people + " " + (people == 1 ? "άτομο" : "άτομα");
    }

    public boolean stepExists(int i) {
        return i < stepSize();
    }

    public int stepSize() {
        return recipe.getSteps().size();
    }

    public boolean stepHasTime(int i) {
        return recipe.getStep(i).time().getSeconds() > 0;
    }

    public long stepSeconds(int i) {
        return recipe.getStep(i).time().getSeconds();
    }

    public String executeRecipeStep(int i) {
        Step step = recipe.getStep(i);

        StringBuilder str = new StringBuilder();

        str.append("Βήμα ").append(i + 1).append(": ").append(step.desc()).append("\n\n");
        str.append("  " + "Υλικά βήματος ").append(i + 1).append(": ");
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
        str.append("\n  Χρόνος βήματος ").append(i + 1).append(": ").append(step.time().toString());

        return str.toString();
    }
}
