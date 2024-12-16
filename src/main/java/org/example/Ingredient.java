package org.example;

public interface Ingredient {

    // Returns name
    String getName();

    // Returns amount
    double getAmount();

    // Returns measure
    String getMeasure();

    // Returns ingredient as string
    @Override
    String toString();

}
