package edu.afigueroacogswell.whatsonthemenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

/*
* TODO: Create the Toolbar so that it can display on every activity.
* TODO: Test to see if it runs.
* Debug Log:
* Class has been refactored
* */
public class AddIngredients extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {


    //region "GLOBAL VARIABLES"

    //Logcat Log
    private final String TAG = "AddIngredients";


    //Buttons - Initialized onCreate
    Button addToDairyButton;
    Button addToFruitsButton;
    Button addToStarchButton;
    Button addToProteinButton;
    Button addToSugarsButton;
    Button addToVegetablesButton;
    Button addToLiquidsButton;
    Button addToCondimentsButton;


    //Spinners - Initialized onCreate
    private Spinner dairySpinner;
    private Spinner fruitsSpinner;
    private Spinner starchSpinner;
    private Spinner proteinSpinner;
    private Spinner sugarsSpinner;
    private Spinner vegetableSpinner;
    private Spinner liquidSpinner;
    private Spinner condimentsSpinner;


    //ArrayList - Initialized onCreate
    private ArrayList<String> dairyArrList = new ArrayList<>();
    private ArrayList<String> fruitsArrList = new ArrayList<>();
    private ArrayList<String> starchArrList = new ArrayList<>();
    private ArrayList<String> proteinsArrList = new ArrayList<>();
    private ArrayList<String> sugarsArrList = new ArrayList<>();
    private ArrayList<String> vegetablesArrList = new ArrayList<>();
    private ArrayList<String> liquidsArrList = new ArrayList<>();
    private ArrayList<String> condimentsArrList = new ArrayList<>();


    //Adapters - Initialized here
    private ArrayAdapter<String> dairyAdp;
    private ArrayAdapter<String> fruitsAdp;
    private ArrayAdapter<String> starchAdp;
    private ArrayAdapter<String> proteinsAdp;
    private ArrayAdapter<String> sugarsAdp;
    private ArrayAdapter<String> vegetablesAdp;
    private ArrayAdapter<String> liquidAdp;
    private ArrayAdapter<String> condimentsAdp;

    //endregion "GLOBAL VARIABLES"


    //region "ACTIVITY LIFECYCLE METHODS"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_ingredients);


        //DEBUG STATE LOG
        Log.d(TAG, "Create State");


        //region "TOOLBAR SET-UP"
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //endregion "TOOLBAR SET-UP"


        //region "BUTTON SET-UP"
        addToDairyButton = (Button) findViewById(R.id.add_to_dairy_button);
        addToFruitsButton = (Button) findViewById(R.id.add_to_fruits_button);
        addToStarchButton = (Button) findViewById(R.id.add_to_starch_button);
        addToProteinButton = (Button) findViewById(R.id.add_to_proteins_button);
        addToSugarsButton = (Button) findViewById(R.id.add_to_sugars_button);
        addToVegetablesButton = (Button) findViewById(R.id.add_to_vegetables_button);
        addToLiquidsButton = (Button) findViewById(R.id.add_to_liquids_button);
        addToCondimentsButton = (Button) findViewById(R.id.add_to_condiments_button);


        addToDairyButton.setOnClickListener(this);
        addToFruitsButton.setOnClickListener(this);
        addToStarchButton.setOnClickListener(this);
        addToProteinButton.setOnClickListener(this);
        addToSugarsButton.setOnClickListener(this);
        addToVegetablesButton.setOnClickListener(this);
        addToLiquidsButton.setOnClickListener(this);
        addToCondimentsButton.setOnClickListener(this);

        //endregion "BUTTON SET-UP"


        //region "SPINNER SET-UP"
        dairySpinner = (Spinner) findViewById(R.id.dairy_spinner);
        fruitsSpinner = (Spinner) findViewById(R.id.fruits_spinner);
        starchSpinner = (Spinner) findViewById(R.id.starch_spinner);
        proteinSpinner = (Spinner) findViewById(R.id.proteins_spinner);
        sugarsSpinner = (Spinner) findViewById(R.id.sugars_spinner);
        vegetableSpinner = (Spinner) findViewById(R.id.vegetables_spinner);
        liquidSpinner = (Spinner) findViewById(R.id.liquids_spinner);
        condimentsSpinner = (Spinner) findViewById(R.id.condiments_spinner);


        //ADD DEFAULT VALUES ONTO ARRAYLIST FOR SPINNERS, TODO: Change second argument to an array. Use the string array to make that its values.
        initDefaultSpinnerValues(dairyArrList, 3);
        initDefaultSpinnerValues(fruitsArrList, 3);
        initDefaultSpinnerValues(starchArrList, 3);
        initDefaultSpinnerValues(proteinsArrList, 3);
        initDefaultSpinnerValues(sugarsArrList, 3);
        initDefaultSpinnerValues(vegetablesArrList, 3);
        initDefaultSpinnerValues(liquidsArrList, 3);
        initDefaultSpinnerValues(condimentsArrList, 3);

        //endregion "SPINNER SET-UP"


        //region "ADAPTER SET UP"
        dairyAdp = new ArrayAdapter<> (this, android.R.layout.simple_spinner_dropdown_item, dairyArrList);
        fruitsAdp = new ArrayAdapter<> (this, android.R.layout.simple_spinner_dropdown_item, fruitsArrList);
        starchAdp = new ArrayAdapter<> (this, android.R.layout.simple_spinner_dropdown_item, starchArrList);
        proteinsAdp = new ArrayAdapter<> (this, android.R.layout.simple_spinner_dropdown_item, proteinsArrList);
        sugarsAdp = new ArrayAdapter<> (this, android.R.layout.simple_spinner_dropdown_item, sugarsArrList);
        vegetablesAdp = new ArrayAdapter<> (this, android.R.layout.simple_spinner_dropdown_item, vegetablesArrList);
        liquidAdp = new ArrayAdapter<> (this, android.R.layout.simple_spinner_dropdown_item, liquidsArrList);
        condimentsAdp = new ArrayAdapter<> (this, android.R.layout.simple_spinner_dropdown_item, condimentsArrList);

        initAdapters(dairyAdp, dairySpinner);
        initAdapters(fruitsAdp, fruitsSpinner);
        initAdapters(starchAdp, starchSpinner);
        initAdapters(proteinsAdp, proteinSpinner);
        initAdapters(sugarsAdp, sugarsSpinner);
        initAdapters(vegetablesAdp, vegetableSpinner);
        initAdapters(liquidAdp, liquidSpinner);
        initAdapters(condimentsAdp, condimentsSpinner);

        //endregion "ADAPTER SET-UP"
    }


    //Runs Everytime we Restart Application
    //Load SQL data here.
    @Override
    public void onStart()
    {
        super.onStart();
        Log.i(TAG, "Start State");

        //Reload Data
        for (Refrigerator.FoodTypes type: Refrigerator.FoodTypes.values()) //go through all classes.
        {
            //Log.i(TAG, type.name());
            for (Map.Entry<String, FoodItem> entry: type.getFoodMap().entrySet())
            {
                //Log.i(TAG, "\t" + entry.getKey());
                if(entry.getKey().isEmpty())
                {
                    continue;
                }
                else
                {
                    addToSpinners(entry.getKey(), type);
                }
            }
        }
    }

    //Runs When another Activity runs on the ForeGround
    @Override
    public void onPause()
    {
        super.onPause();
        Log.i(TAG, "Pause State");
    }

    //Runs Everytime we Restart Application and after Pausing
    @Override
    public void onResume()
    {
        super.onResume();
        Log.i(TAG, "Resume State");

        //Check if we are adding an item or cancelling the addition
        if (Refrigerator.getInstance().getLatestFoodType() != Refrigerator.FoodTypes.NONE)
        {
            FoodItem foodItem = Refrigerator.getInstance().getLatestFoodItem();
            Refrigerator.FoodTypes foodType = Refrigerator.getInstance().getLatestFoodType();

            if (foodItem != null && foodType != null) {

                addToSpinners(foodItem.getName(), foodType);
                Log.i(TAG, foodItem.getName() + " added to " + foodType.toString() + " Spinner!");
            }
        }
        else{ Log.i(TAG, "Cancel Spinner Addition"); }
    }

    //Runs when this activity is no longer visible.
    //Release all of user's resources //ArrayList values.
    @Override
    public void onStop()
    {
        super.onStop();
        Log.i(TAG, "onStop State");


    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        Log.i(TAG, "onRestart State");
    }



    //Runs when application is killed/Closed
    //Use this to save data onto the sql database.
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.i(TAG, "onDestroy State");
    }
    //endregion "ACTIVITY LIFECYCLE METHODS"


    //region "CLASS METHODS"

    //region "INITIALIZATION METHODS"
    private void initDefaultSpinnerValues(ArrayList<String> arrayList, int valueAmmount)
    {
        for (int i = 0; i < valueAmmount; i++) {
            arrayList.add("TEST");
        }
    }

    private void initAdapters(ArrayAdapter<String> adapter, Spinner spinner)
    {
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    //endregion "INITIALIZATION METHODS"


    public void addToSpinners(String foodName, Refrigerator.FoodTypes foodType)
    {
        switch(foodType)
        {
            case DAIRY:
                Log.d(Refrigerator.FoodTypes.DAIRY.name(), "Executed");
                updateAdapter(dairyAdp, dairyArrList, foodName);


                break;
            case FRUITS:
                Log.i(Refrigerator.FoodTypes.FRUITS.name(), "Executed");
                updateAdapter(fruitsAdp, fruitsArrList, foodName);


                break;
            case STARCH:
                Log.i(Refrigerator.FoodTypes.STARCH.name(), "Executed");
                updateAdapter(starchAdp, starchArrList, foodName);


                break;
            case PROTEINS:
                Log.i(Refrigerator.FoodTypes.PROTEINS.name(), "Executed");
                updateAdapter(proteinsAdp, proteinsArrList, foodName);


                break;
            case SUGARS:
                Log.i(Refrigerator.FoodTypes.SUGARS.name(), "Executed");
                updateAdapter(sugarsAdp, sugarsArrList, foodName);


                break;
            case VEGETABLES:
                Log.i(Refrigerator.FoodTypes.VEGETABLES.name(), "Executed");
                updateAdapter(vegetablesAdp, vegetablesArrList, foodName);


                break;
            case LIQUIDS:
                Log.i(Refrigerator.FoodTypes.LIQUIDS.name(), "Executed");
                updateAdapter(liquidAdp, liquidsArrList, foodName);


                break;
            case CONDIMENTS:
                Log.i(Refrigerator.FoodTypes.CONDIMENTS.name(), "Executed");
                updateAdapter(condimentsAdp, condimentsArrList, foodName);


                break;

            default:
                //TODO: Create toast to know if he/she somehow gets default activated.
                break;
        }
    }

    private void updateAdapter(ArrayAdapter<String> adapter, ArrayList<String> arrayList, String newItem)
    {
        if(adapter == null)
        {
            Log.d(TAG, "Adapter is Null");
            return;
        }
        else {
            arrayList.add(newItem);
            adapter.notifyDataSetChanged();
        }
    }
    //endregion "CLASS METHODS"


    // region "LISTENERS METHODS"
    //Handles add_to_Button_Click Listeners
    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.add_to_dairy_button:
                Log.i(TAG, "Dairy Button Executed!");
                PopUpForm.foodTypes = Refrigerator.FoodTypes.DAIRY;
                startActivity(new Intent(AddIngredients.this, PopUpForm.class));


                break;
            case R.id.add_to_fruits_button:
                Log.i(TAG, "Fruits Button Executed!");
                PopUpForm.foodTypes = Refrigerator.FoodTypes.FRUITS;
                startActivity(new Intent(AddIngredients.this, PopUpForm.class));


                break;
            case R.id.add_to_starch_button:
                Log.i(TAG, "Starch Button Executed!");
                PopUpForm.foodTypes = Refrigerator.FoodTypes.STARCH;
                startActivity(new Intent(AddIngredients.this, PopUpForm.class));


                break;
            case R.id.add_to_proteins_button:
                Log.d(TAG, "Proteins Button Executed!");
                PopUpForm.foodTypes = Refrigerator.FoodTypes.PROTEINS;
                startActivity(new Intent(AddIngredients.this, PopUpForm.class));


                break;
            case R.id.add_to_sugars_button:
                Log.i(TAG, "Sugars Button Executed!");
                PopUpForm.foodTypes = Refrigerator.FoodTypes.SUGARS;
                startActivity(new Intent(AddIngredients.this, PopUpForm.class));


                break;
            case R.id.add_to_vegetables_button:
                Log.d(TAG, "Vegetables Button Executed!");
                PopUpForm.foodTypes = Refrigerator.FoodTypes.VEGETABLES;
                startActivity(new Intent(AddIngredients.this, PopUpForm.class));


                break;
            case R.id.add_to_liquids_button:
                Log.i(TAG, "Liquids Button Executed!");
                PopUpForm.foodTypes = Refrigerator.FoodTypes.LIQUIDS;
                startActivity(new Intent(AddIngredients.this, PopUpForm.class));

                break;
            case R.id.add_to_condiments_button:
                //do code
                Log.d(TAG, "Condiments Button Executed!");
                PopUpForm.foodTypes = Refrigerator.FoodTypes.CONDIMENTS;
                startActivity(new Intent(AddIngredients.this, PopUpForm.class));
                break;

            default:
                //TODO: Create a Toast to deal with default state.


                break;
        }
    }


    //Handles the Menu Creation set up.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_addingredients, menu);
        return true;
    }


    //Handles button listener for menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        /*
        * Handle action bar item clicks here. The action bar will
        * automatically handle clicks on te Home/Up button, so long
        * as you specify a parent activity in AndroidManifest.xml
        * */
        int id = item.getItemId();

        if (id == R.id.add_ingredients_action_settings) //this is the three dots on the toolbar for settings
        {
            Toast.makeText(this, "Add-Ingredients: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.home)
        {
            //takes me back to parent activity.
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }


    //Spinner Listener Functions
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //TextView itemSelectedTxt = (TextView) view;
        //Toast.makeText(this, "You Selected: ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    //#endregion "LISTENER METHODS"
}
