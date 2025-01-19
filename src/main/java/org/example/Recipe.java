package org.example;

import java.util.List;

/**
 * A recipe interface
 */
public interface Recipe {

    /**
     * Returns steps.
     *
     * @return steps the steps of the recipe in a list
     */
    List<Step> getSteps();

    /**
     * Returns instructions.
     *
     * @return str the recipe instructions
     */
    String getRecipe();

    /**
     * Gets an index i and returns the step in this index.
     *
     * @param i the index
     * @return step the step
     */
    Step getStep(int i);

}
