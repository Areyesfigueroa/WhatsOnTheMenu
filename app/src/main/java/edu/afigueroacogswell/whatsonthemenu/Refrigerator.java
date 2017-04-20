package edu.afigueroacogswell.whatsonthemenu;

import android.support.v7.app.AppCompatActivity;

import java.util.Dictionary;
import java.util.Enumeration;
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

    //Header Strings for localization
    final String proteinsHeader = getResources().getString(R.string.proteins_header);
    final String vegetablesHeader = getResources().getString(R.string.vegetables_header);
    final String starchHeader = getResources().getString(R.string.starch_header);
    final String condimentsHeader = getResources().getString(R.string.condiments_header);

    private Map<String, FoodItem> proteinsDic = new HashMap<String, FoodItem>();
    private Map<String, FoodItem> vegetablesDic = new HashMap<String, FoodItem>();
    private Map<String, FoodItem> starchDic = new HashMap<String, FoodItem>();
    private Map<String, FoodItem> condimentsDic = new HashMap<String, FoodItem>();

    protected void addFoodItem(FoodItem fItem, String foodType)
    {
        if (proteinsHeader.equals(foodType))
            proteinsDic.put(fItem.getName(), fItem);

        if(vegetablesHeader.equals(foodType))
            vegetablesDic.put(fItem.getName(), fItem);

        if(starchHeader.equals(foodType))
            starchDic.put(fItem.getName(), fItem);

        if(condimentsHeader.equals(foodType))
            condimentsDic.put(fItem.getName(), fItem);
    }

    /*
    * SETTERS for dictionary elements.
    * */
    public void setProteinsMapElem(String key, FoodItem value) {
        this.proteinsDic.put(key, value); //Replace
    }

    public void setVegetablesMapElem(String key, FoodItem value) {
        this.vegetablesDic.put(key, value);
    }

    public void setStarchMapElem(String key, FoodItem value) {
        this.starchDic.put(key, value);
    }

    public void setCondimentsMapElem(String key, FoodItem value) {
        this.condimentsDic.put(key, value);
    }

    /*
    * GETTERS, TODO: test to see if the setters are obsolete.
    * */
    public Map<String, FoodItem> getProteinsDic() {
        return proteinsDic;
    }

    public Map<String, FoodItem> getVegetablesDic() {
        return vegetablesDic;
    }

    public Map<String, FoodItem> getStarchDic() {
        return starchDic;
    }

    public Map<String, FoodItem> getCondimentsDic() {
        return condimentsDic;
    }
}


