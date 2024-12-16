package org.example;

/**
 * An ingredient interface
 */
public interface Ingredient {

    /**
     * Returns name.
     *
     * @return name the name of the ingredient
     */
    String getName();

    /**
     * Returns amount.
     *
     * @return amount the amount of the ingredient
     */
    double getAmount();

    /**
     * Returns measure.
     *
     * @return measure the measure of the ingredient
     */
    String getMeasure();

    /**
     * Returns information.
     *
     * @return str a string of information of the ingredient
     */
    @Override
    String toString();

}
