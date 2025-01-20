package org.example;

public class ExecuteRecipeModel extends RecipeModel {
    private int index = 0;

    public ExecuteRecipeModel(String file, int people) {
        super(file, people);
    }

    public String executeRecipeStart() {
        return "Εκτέλεση Συνταγής: " + getFileName() + " για " + getPeople() + " " + (getPeople() == 1 ? "άτομο" : "άτομα");
    }

    public boolean stepExists(int i) {
        return i < stepSize();
    }

    public int stepSize() {
        return getRecipe().getSteps().size();
    }

    public boolean stepHasTime(int i) {
        return getRecipe().getStep(i).time().getSeconds() > 0;
    }

    public long stepSeconds(int i) {
        return getRecipe().getStep(i).time().getSeconds();
    }

    public String executeRecipeStep(int i) {
        Step step = getRecipe().getStep(i);

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

    public int getIndex() {
        return index;
    }

    public void increaseIndex() {
        index++;
    }
}
