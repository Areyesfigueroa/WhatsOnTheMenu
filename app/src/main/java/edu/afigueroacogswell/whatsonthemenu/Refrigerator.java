package edu.afigueroacogswell.whatsonthemenu;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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

    private final String TAG = "Refrigerator Class: ";

    //Test Before Changing Anything
    public enum FoodTypes
    {
        //THE NAMES CAN BE USED AS ID's instead of literal strings
        DAIRY("Dairy"), FRUITS("Fruits"), STARCH("Starch"), PROTEINS("Proteins"), CONFECTIONS("Confections"), VEGETABLES("Vegetables"), LIQUIDS("Liquids"), CONDIMENTS("Condiments");

        private final String stringName;
        private Map<String, FoodItem> food = new HashMap<String, FoodItem>();

        private FoodTypes(String id)
        {
            this.stringName = id;
        }

        @Override
        public String toString()
        {
            return stringName;
        }

        /*
        * food map Wrapper methods
        * */
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
    }


    /*
    * Debugging Methods
    * */
    public void printEntry(FoodTypes type, String key)
    {
        Log.d(TAG, type.getFoodElement(key).getName());
    }

    public void printRefrigerator()
    {
        for (FoodTypes type: FoodTypes.values())
        {
            Log.d(TAG, type.name());
            Log.d("KEY", "VALUE");
            for (Map.Entry<String, FoodItem> entry: type.getFoodMap().entrySet())
            {
                Log.d("Entry: ", "\t" + entry.getKey() +", "+ entry.getValue().getName()+"Item");
            }
        }
    }
}


