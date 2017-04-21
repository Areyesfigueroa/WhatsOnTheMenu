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
    final static String PROTEINS_HEADER = "Proteins";
    final static String VEGETABLES_HEADER = "Vegetables";
    final static String STARCH_HEADER = "Starch";
    final static String CONDIMENTS_HEADER = "Condiments";

    //Test Before Changing Anything
    public enum FoodTypes
    {
        //THE NAMES CAN BE USED AS ID's instead of literal strings
        DAIRY("Dairy"), FRUITS("Fruits"), STARCH("Starch"), PROTEINS("Proteins"), CONFECTIONS("Confections"), VEGETABLES("Vegetables"), LIQUIDS("Liquids"), CONDIMENTS("Condiments");

        private final String id;
        private Map<String, FoodItem> food = new HashMap<String, FoodItem>();

        private FoodTypes(String id)
        {
            this.id = id;
        }

        public String getID()
        {
            return id;
        }

        /*
        * food map Wrapper methods
        * */
        private void add(String foodName, FoodItem foodItem)
        {
            food.put(foodName, foodItem);
        }

        private void overwrite(String foodName, FoodItem foodItem)
        {
            food.put(foodName, foodItem);
        }

        private void remove(String key)
        {
            food.remove(key);
        }

        private FoodItem getFoodElement(String key)
        {
            return food.get(key);
        }

        private boolean isEmpty()
        {
            return food.isEmpty();
        }

        private boolean contains(String key)
        {
            if(food.get(key) != null)
                return true;
            else
                return false;
        }

        private Map<String, FoodItem> getFoodMap()
        {
            return food;
        }
    }

    private void testing()
    {
        FoodItem milk = new FoodItem();
        FoodTypes dairy = FoodTypes.DAIRY;
        dairy.getID();
        dairy.add(milk.getName(), milk);
    }

    private Map<String, FoodItem> proteinsMap = new HashMap<String, FoodItem>();
    private Map<String, FoodItem> vegetablesMap = new HashMap<String, FoodItem>();
    private Map<String, FoodItem> starchMap = new HashMap<String, FoodItem>();
    private Map<String, FoodItem> condimentsMap = new HashMap<String, FoodItem>();


    //TODO: Test that items are going into the refrigerator.
    protected void addFoodItem(FoodItem fItem, String foodType)
    {
        if (PROTEINS_HEADER.equals(foodType))
            proteinsMap.put(fItem.getName(), fItem);

        if(VEGETABLES_HEADER.equals(foodType))
            vegetablesMap.put(fItem.getName(), fItem);

        if(STARCH_HEADER.equals(foodType))
            starchMap.put(fItem.getName(), fItem);

        if(CONDIMENTS_HEADER.equals(foodType))
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


