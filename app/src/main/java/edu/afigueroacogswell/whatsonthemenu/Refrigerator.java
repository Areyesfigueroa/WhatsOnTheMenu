package edu.afigueroacogswell.whatsonthemenu;

import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aliel on 4/19/2017.
 */

/*
* Store on a Database SQL for future use.
* Non-Static class may need to need to be instantiated in the future.
* */
public class Refrigerator extends AppCompatActivity
{

    private static Refrigerator refrigerator = new Refrigerator( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Refrigerator() { }

    /* Static 'instance' method so that you can call it without instantiating*/
    public static Refrigerator getInstance( ) {
        return refrigerator;
    }

    //Header Strings
    final static String proteinsHeader = "Proteins";
    final static String vegetablesHeader = "Vegetables";
    final static String starchHeader = "Starch";
    final static String condimentsHeader = "Condiments";

    private Map<String, FoodItem> proteinsMap = new HashMap<String, FoodItem>();
    private Map<String, FoodItem> vegetablesMap = new HashMap<String, FoodItem>();
    private Map<String, FoodItem> starchMap = new HashMap<String, FoodItem>();
    private Map<String, FoodItem> condimentsMap = new HashMap<String, FoodItem>();


    //TODO: Test that items are going into the refrigerator.
    protected void addFoodItem(FoodItem fItem, String foodType)
    {
        if (proteinsHeader.equals(foodType))
            proteinsMap.put(fItem.getName(), fItem);

        if(vegetablesHeader.equals(foodType))
            vegetablesMap.put(fItem.getName(), fItem);

        if(starchHeader.equals(foodType))
            starchMap.put(fItem.getName(), fItem);

        if(condimentsHeader.equals(foodType))
            condimentsMap.put(fItem.getName(), fItem);
    }

    /*
    * SETTERS for dictionary elements.
    * */
    public void setProteinsMapElem(String key, FoodItem value) {
        this.proteinsMap.put(key, value); //Replace
    }

    public void setVegetablesMapElem(String key, FoodItem value) {
        this.vegetablesMap.put(key, value);
    }

    public void setStarchMapElem(String key, FoodItem value) {
        this.starchMap.put(key, value);
    }

    public void setCondimentsMapElem(String key, FoodItem value) {
        this.condimentsMap.put(key, value);
    }

    /*
    * GETTERS, TODO: test to see if the setters are obsolete.
    * */
    public Map<String, FoodItem> getProteinsMap() {
        return proteinsMap;
    }

    public Map<String, FoodItem> getVegetablesMap() {
        return vegetablesMap;
    }

    public Map<String, FoodItem> getStarchMap() {
        return starchMap;
    }

    public Map<String, FoodItem> getCondimentsMap() {
        return condimentsMap;
    }
}


