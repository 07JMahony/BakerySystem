package com.example.semster1assignment1;

public class Recipe {
    public String ingredient1;
    public String ingredient2;
    public String ingredient3;
    public String quantity;

    public FunkyList<Ingredient> ingredientList = new FunkyList<>();

    //CONSTRUCTOR

    public Recipe(String ingredient1, String ingredient2, String ingredient3, String quantity){
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.quantity = quantity;
    }

    //SETTERS AND GETTERS


    public String getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(String ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(String ingredient2) {
        this.ingredient2 = ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public void setIngredient3(String ingredient3) {
        this.ingredient3 = ingredient3;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "   Ingredient One : "+ ingredient1 +
                "   Ingredient Two : "+ ingredient2+
                "   Ingredient Three :"+ ingredient3+
                "   Quantity : "+ quantity;
    }
}
