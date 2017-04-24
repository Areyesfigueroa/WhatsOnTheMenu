package edu.afigueroacogswell.whatsonthemenu;

/**
 * Created by aliel on 4/19/2017.
 */

public class FoodItem
{
    String name;
    float portionSize;
    String unitMeasurement;
    int totalServings;

    FoodItem(String name, float portionSize, String unitMeasurement,  int totalServings)
    {
        this.name = name;
        this.portionSize = portionSize;
        this.unitMeasurement = unitMeasurement;
        this.totalServings = totalServings;
    }

    FoodItem()
    {
        this.name = "";
        this.portionSize = 0;
        this.unitMeasurement = "";
        this.totalServings = 0;
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

    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
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

    public String getUnitMeasurement() {
        return unitMeasurement;
    }
}
