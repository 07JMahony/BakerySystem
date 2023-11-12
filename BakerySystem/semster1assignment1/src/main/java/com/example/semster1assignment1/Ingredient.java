package com.example.semster1assignment1;

public class Ingredient {
    public String name;
    public String description;
    public String calories;

    public Ingredient(String name, String description, String calories){
        this.name = name;
        this.description = description;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "   Name : "+ name +
                "   Description : "+ description +
                "   Calories per 100g : "+ calories;
    }
}

