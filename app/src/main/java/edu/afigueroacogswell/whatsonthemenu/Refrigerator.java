package edu.afigueroacogswell.whatsonthemenu;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
* TODO: Store on a Database SQL for future use.
* Debug Logs:
* Non-Static class may need to need to be instantiated in the future.
* */
public class Refrigerator extends AppCompatActivity
{

    //region "GLOBAL VARIABLES"


    private final String TAG = "Refrigerator";
    private FoodItem latestFoodItem = new FoodItem();
    private FoodTypes latestFoodType;

    private static Refrigerator refrigerator = new Refrigerator( );


    //A private Constructor prevents any other class from instantiating.
    private Refrigerator()
    {
        latestFoodType = FoodTypes.NONE;
    }


    //Static 'instance' method so that you can call it without instantiating
    public static Refrigerator getInstance( ) {
        return refrigerator;
    }

    //endregion "GLOBAL VARIABLES"


    //region "ENUM CLASS"
    public enum FoodTypes
    {
        //THE NAMES CAN BE USED AS ID's instead of literal strings
        DAIRY("Dairy"), FRUITS("Fruits"), STARCH("Starch"), PROTEINS("Proteins"), SUGARS("Sugars"), VEGETABLES("Vegetables"), LIQUIDS("Liquids"), CONDIMENTS("Condiments"), NONE("None");


        private final String stringName;
        private Map<String, FoodItem> food = new HashMap<String, FoodItem>();


        //Constructor
        private FoodTypes(String id)
        {
            this.stringName = id;
        }


        //Gets the name of constant class and returns the name with first letter uppercase and the rest lowercase.
        //Its a different way to print the name.
        @Override
        public String toString()
        {
            return stringName;
        }


        //region "FOOD MAP WRAPPER METHODS"
        public void add(String foodName, FoodItem foodItem)
        {
            food.put(foodName, foodItem);
        }

        public void overwrite(String foodName, FoodItem foodItem)
        {
            food.put(foodName, foodItem);
        }

        public void remove(String key)
        {
            food.remove(key);
        }

        public FoodItem getFoodElement(String key)
        {
            return food.get(key);
        }

        public boolean isEmpty()
        {
            return food.isEmpty();
        }

        public boolean contains(String key)
        {
            if(food.get(key) != null)
                return true;
            else
                return false;
        }

        public Map<String, FoodItem> getFoodMap()
        {
            return food;
        }

        //endregion "FOOD MAP WRAPPER METHODS"
    }

    //endregion Class's Enum Class


    //region "CLASS METHODS"

    //Setters And Getters
    public void setLatestFoodItem(FoodItem latestFoodItem) {
        this.latestFoodItem = latestFoodItem;
    }


    public FoodItem getLatestFoodItem() {
        return latestFoodItem;
    }


    public void setLatestFoodType(FoodTypes latestFoodType) {
        this.latestFoodType = latestFoodType;
    }


    public FoodTypes getLatestFoodType() {
        return latestFoodType;
    }


    //Debug Methods
    public void printEntry(FoodTypes type, String key)
    {
        Log.i(TAG, type.getFoodElement(key).getName());
    }

    public void printRefrigerator()
    {
        for (FoodTypes type: FoodTypes.values())
        {
            Log.i(TAG, type.name());
            for (Map.Entry<String, FoodItem> entry: type.getFoodMap().entrySet())
            {
                Log.i(TAG, "\t" + entry.getKey() +", "+ entry.getValue().getName()+"Item");
            }
        }
    }

    //endregion "CLASS METHODS"
}


