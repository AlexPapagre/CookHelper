package org.example;

import java.util.List;

public record Step(String desc, List<Ingredient> ingredients, List<Utensil> utensils, Time time) {
}
