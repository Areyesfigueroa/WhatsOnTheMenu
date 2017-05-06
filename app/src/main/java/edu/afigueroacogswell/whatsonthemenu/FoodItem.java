package edu.afigueroacogswell.whatsonthemenu;

import java.util.ArrayList;

/**
 * Created by aliel on 4/19/2017.
 */

public class FoodItem
{
    private String name;
    private float portionSize;
    private int totalServings;
    private Units unitMeasurement;
    private ArrayList<Tags> foodTags;

    //TAGS used to differentiate the food when creating or adding an Ingredient. Move to refrigerator.
    public enum Tags
    {
        BREAKFAST("Breakfast"), LUNCH("Lunch"), DINNER("Dinner"), SNACKS("Snack"), DESSERT("Dessert"), GENERAL("General");

        String id;
        ArrayList<FoodItem> foods;

        Tags(String name)
        {
            id = name;
            foods = new ArrayList<FoodItem>();
        }

        public String getStringID()
        {
            return id;
        }

        //Wrapper
        void add(FoodItem food)
        {
            foods.add(food);
        }

        void remove(FoodItem food)
        {
            foods.remove(food);
        }

        ArrayList<FoodItem> getFoodList()
        {
            return foods;
        }

        FoodItem getFood(int index)
        {
            return foods.get(index);
        }
    }

    //Measurement Units, Move to refrigerator
    public enum Units
    {
        GRAMS, OUNCES;
    }

    FoodItem(String name, float portionSize,  int totalServings, Units units, ArrayList<Tags> tags)
    {
        this.name = name;
        this.portionSize = portionSize;
        this.totalServings = totalServings;
        this.unitMeasurement = units;
        this.foodTags = tags;
    }

    FoodItem()
    {
        this.name = "";
        this.portionSize = 0;
        this.unitMeasurement = Units.values()[0];
        this.totalServings = 0;
        this.foodTags = new ArrayList<>();
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPortionSize(float portionSize) {
        this.portionSize = portionSize;
    }

    public void setTotalServings(int totalServings) {
        this.totalServings = totalServings;
    }


    //Getters
    public String getName() {
        return name;
    }

    public float getPortionSize() {
        return portionSize;
    }

    public int getTotalServings() {
        return totalServings;
    }

    public Units getUnitMeasurement() {
        return unitMeasurement;
    }

    public ArrayList<Tags> getTags()
    {
        return foodTags;
    }
}
