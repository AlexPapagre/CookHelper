package org.example;

import java.util.List;

public interface Recipe {

    // Returns the steps of the recipe in a list
    List<Step> getSteps();

    // Returns the recipe instructions
    String getRecipe();

}
