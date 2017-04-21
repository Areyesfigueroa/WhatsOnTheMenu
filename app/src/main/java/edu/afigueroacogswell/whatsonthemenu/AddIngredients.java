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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.type;

/*
* TODO: Create the Toolbar so that it can display on every activity.
*
* Debug Log:
* Activity kept crashing because it needed to be implemented or called in the
* android mainfest file
* */
public class AddIngredients extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    /*Global References
    * */
    Spinner spinner;
    Button addToProteinButton;
    Button addToVegetablesButton;
    Button addToStarchButton;
    Button addToCondimentsButton;


    /*
    * Testing Refrigerator Enum Instances.
    * */


    /*
    * Dynamic Spinner variables
    * */
    private static ArrayList<String> proteinArrList = new ArrayList<>();
    private static ArrayList<String> vegetablesArrList = new ArrayList<>();
    private static ArrayList<String> starchArrList = new ArrayList<>();
    private static ArrayList<String> condimentsArrList = new ArrayList<>();

    Spinner proteinSpinner;
    Spinner vegetableSpinner;
    Spinner starchSpinner;
    Spinner condimentsSpinner;

    public AddIngredients(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_ingredients);

        /*
        * Button SetUp
        * */
        initButtons();

        /*
        * Toolbar set up
        * */
        initToolBar();

        /*
        * Resource ID for spinner initialization.
        * */
        int spinnerIDs[] = {R.id.Proteins, R.id.Vegetables, R.id.Starch, R.id.Condiments}; //instance id of the spinners.
        int spinnerArrs[] = {R.array.ProteinsArray, R.array.VegetablesArray, R.array.StarchArray, R.array.CondimentsArray}; //default values.

        initSpinners(spinnerIDs, spinnerArrs);
    }


    private void initButtons()
    {
        addToProteinButton = (Button) findViewById(R.id.add_to_proteins_button);
        addToVegetablesButton = (Button) findViewById(R.id.add_to_vegetables_button);
        addToStarchButton = (Button) findViewById(R.id.add_to_starch_button);
        addToCondimentsButton = (Button) findViewById(R.id.add_to_condiments_button);

        addToProteinButton.setOnClickListener(this);
        addToVegetablesButton.setOnClickListener(this);
        addToStarchButton.setOnClickListener(this);
        addToCondimentsButton.setOnClickListener(this);
    }

    private void initToolBar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /*
    * Testing
    * */
    void initSpinners()
    {
        proteinSpinner = (Spinner) findViewById(R.id.Proteins);
        vegetableSpinner = (Spinner) findViewById(R.id.Vegetables);
        starchSpinner = (Spinner) findViewById(R.id.Starch);
        condimentsSpinner = (Spinner) findViewById(R.id.Condiments);

        //dynamic
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter); //set the adpater for the spinner

        //static
        spinner.setOnItemSelectedListener(this); //Stating which class is responsible for handling the listeners.
    }

    /*
    * Affects the class not the instance.
    * */
    protected static void addToSpinners(String foodName, Refrigerator.FoodTypes foodType)
    {
        switch(foodType)
        {
            case DAIRY:
                Log.d(Refrigerator.FoodTypes.DAIRY.name(), "Executed");

                break;
            case FRUITS:
                Log.d(Refrigerator.FoodTypes.FRUITS.name(), "Executed");

                break;
            case STARCH:
                Log.d(Refrigerator.FoodTypes.STARCH.name(), "Executed");

                break;
            case PROTEINS:
                Log.d(Refrigerator.FoodTypes.PROTEINS.name(), "Executed");

                break;
            case CONFECTIONS:
                Log.d(Refrigerator.FoodTypes.CONFECTIONS.name(), "Executed");

                break;
            case VEGETABLES:
                Log.d(Refrigerator.FoodTypes.VEGETABLES.name(), "Executed");

                break;
            case LIQUIDS:
                Log.d(Refrigerator.FoodTypes.LIQUIDS.name(), "Executed");

                break;
            case CONDIMENTS:
                Log.d(Refrigerator.FoodTypes.CONDIMENTS.name(), "Executed");

                break;
        }
    }

    /*
    * Handle add_to_Button_Click Listeners
    * */

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.add_to_proteins_button:
                //do code
                Log.d("proteins_button", "Executed");
                PopUpForm.foodTypes = Refrigerator.FoodTypes.PROTEINS;
                startActivity(new Intent(AddIngredients.this, PopUpForm.class));

                break;
            case R.id.add_to_vegetables_button:
                //do code
                Log.d("vegetables_button", "Executed");
                PopUpForm.foodTypes = Refrigerator.FoodTypes.VEGETABLES;
                startActivity(new Intent(AddIngredients.this, PopUpForm.class));
                break;
            case R.id.add_to_starch_button:
                //do code
                Log.d("starch_button", "Executed");
                PopUpForm.foodTypes = Refrigerator.FoodTypes.STARCH;
                startActivity(new Intent(AddIngredients.this, PopUpForm.class));

                break;
            case R.id.add_to_condiments_button:
                //do code
                Log.d("condiments_button", "Executed");
                PopUpForm.foodTypes = Refrigerator.FoodTypes.CONDIMENTS;
                startActivity(new Intent(AddIngredients.this, PopUpForm.class));

                break;
            default:
                break;
        }
    }

    /*
    * Handles the Menu Creation set up.
    * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_addingredients, menu);
        return true;
    }

    /*
    * Initializes all spinners
    * TODO: Create an adapter that does not create from resources since it limits the array to static strings.
    * */
    private void initSpinners(int spinnerIDs[], int spinnerArrs[])
    {
        for (int index = 0; index < spinnerIDs.length; index++)
        {
            spinner = (Spinner) findViewById(spinnerIDs[index]); //get spinner

            ArrayAdapter adapter = ArrayAdapter.createFromResource(this, spinnerArrs[index], R.layout.support_simple_spinner_dropdown_item); // how to view the slider
            spinner.setAdapter(adapter); //set the adpater for the spinner
            spinner.setOnItemSelectedListener(this); //Stating which class is responsible for handling the listeners.
        }
    }




    /*
    * Button listener for menu items
    * */
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


    /* Spinner Listener Functions
    * */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView itemSelectedTxt = (TextView) view;
        Toast.makeText(this, "You Selected: " + itemSelectedTxt.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
