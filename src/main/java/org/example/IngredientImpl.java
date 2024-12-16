package org.example;

public class IngredientImpl implements Ingredient {
    private String name;
    private double amount;
    private String measure;

    public IngredientImpl(String name, int people) {
        this(name, 1, "", people);
    }

    public IngredientImpl(String name, double amount, int people) {
        this(name, amount, "", people);
    }

    public IngredientImpl(String name, double amount, String measure, int people) {
        this.name = name;
        convertMeasure(amount * people, measure);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getMeasure() {
        return measure;
    }

    @Override
    public String toString() {
        return name + Convertor.convertIngredient(amount, measure);
    }

    private void convertMeasure(double amount, String measure) {
        if (measure.equalsIgnoreCase("gr") || measure.equalsIgnoreCase("γραμμάρια") || measure.equalsIgnoreCase("γραμμάριο")) {
            this.amount = amount;
            this.measure = "gr";
        } else if (measure.equalsIgnoreCase("kg") || measure.equalsIgnoreCase("κιλά") || measure.equalsIgnoreCase("κιλό")) {
            this.amount = amount * 1000;
            this.measure = "gr";
        } else if (measure.equalsIgnoreCase("ml") || measure.equalsIgnoreCase("χιλιοστόλιτρα") || measure.equalsIgnoreCase("χιλιοστόλιτρο")) {
            this.amount = amount;
            this.measure = "ml";
        } else if (measure.equalsIgnoreCase("l") || measure.equalsIgnoreCase("λίτρα") || measure.equalsIgnoreCase("λίτρο")) {
            this.amount = amount * 1000;
            this.measure = "ml";
        } else {
            this.amount = amount;
            this.measure = measure;
        }
    }

}
