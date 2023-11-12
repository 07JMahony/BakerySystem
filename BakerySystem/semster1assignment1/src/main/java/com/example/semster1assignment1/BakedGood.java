package com.example.semster1assignment1;

public class BakedGood {
    public String goodName;
    public String goodOrigin;
    public String goodDescription;
    public String goodImage;

    public FunkyList <Recipe> recipeList = new FunkyList<>();


    public BakedGood(String goodName, String goodOrigin, String goodDescription, String goodImage){
        this.goodName = goodName;
        this.goodOrigin = goodOrigin;
        this.goodDescription = goodDescription;
        this.goodImage = goodImage;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodOrigin() {
        return goodOrigin;
    }

    public void setGoodOrigin(String goodOrigin) {
        this.goodOrigin = goodOrigin;
    }

    public String getGoodDescription() {
        return goodDescription;
    }

    public void setGoodDescription(String goodDescription) {
        this.goodDescription = goodDescription;
    }

    public String getGoodImage() {
        return goodImage;
    }

    public void setGoodImage(String goodImage) {
        this.goodImage = goodImage;
    }

    @Override
    public String toString() {
        return "   Name : " +goodName+
                "   Origin : " +goodOrigin +
                "   Description : "+goodDescription +
                "   Image : "+goodImage;

    }
}
