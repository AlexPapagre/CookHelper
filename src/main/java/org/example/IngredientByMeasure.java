package org.example;

import java.util.HashMap;
import java.util.Map;

public class IngredientByMeasure {
    private final Map<String, Double> measures;

    public IngredientByMeasure(String key, Double value) {
        this.measures = new HashMap<>();
        put(key, value);
    }

    public boolean containsKey(String key) {
        return measures.containsKey(key);
    }

    public Double get(String key) {
        return measures.get(key);
    }

    public void put(String key, Double value) {
        measures.put(key, value);
    }

    public String getAmountMeasure() {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, Double> entry : measures.entrySet()) {
            if (!first) {
                str.append(" και");
            }
            first = false;

            double amount = entry.getValue();
            String measure = entry.getKey();

            // Convert measure
            str.append(Convertor.convertIngredient(amount, measure));
        }
        return str.toString();
    }
}
