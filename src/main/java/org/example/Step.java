package org.example;

import java.util.List;

public class Step {
    private String desc;
    private List<Ingredient> ingredients;
    private List<Utensil> utensils;
    private Time time;

    public Step(String desc, List<Ingredient> ingredients, List<Utensil> utensils, Time time) {
        this.desc = desc;
        this.ingredients = ingredients;
        this.utensils = utensils;
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Utensil> getUtensils() {
        return utensils;
    }

    public Time getTime() {
        return time;
    }

}
