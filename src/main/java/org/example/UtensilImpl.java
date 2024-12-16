package org.example;

public class UtensilImpl implements Utensil {
    private String name;

    public UtensilImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
