package edu.afigueroacogswell.whatsonthemenu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Dictionary;
import java.util.Enumeration;

/**
 * Created by aliel on 4/19/2017.
 */

public class PopUpForm extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener
{
   // public static String headerString;
    public static Refrigerator.FoodTypes foodTypes;

    //Debugging
    private final String TAG = this.getClass().getName();

    TextView headerText;

    //Input Content
    EditText nameEditText;
    EditText portionsEditText;
    EditText servingsEditText;

    String inputFoodName;
    String inputUnitMeasurements; //spinner variable
    float inputPortionSize;
    int inputTotalServings;

    //Buttons
    Button createButton;
    Button cancelButton;

    //Spinner
    String[] units = new String[2];
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupform);

        /*
        * Set up Header for form
        * */
        headerText = (TextView) findViewById(R.id.form_header_text);
        headerText.setText(foodTypes.toString());

        /*
        * Set Form Input Contents
        * */
        nameEditText = (EditText) findViewById(R.id.input_ingredient_name_text);
        portionsEditText= (EditText) findViewById(R.id.input_portions);
        servingsEditText = (EditText) findViewById(R.id.input_servings);


        /*
        * Units Spinner set up
        * We do not care at the moments. Add unit measurements later onto the project.
        * */

        //Spinner Contents Set up
        units[0] = "grams";
        units[1] = "ounces";

        //Spinner set up
        spinner = (Spinner) findViewById(R.id.unit_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, units);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        /*
        * Button Set up
        * */
        createButton = (Button) findViewById(R.id.create_button);
        cancelButton = (Button) findViewById(R.id.cancel_button);

        createButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        //Contains the width and height of the screen
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        final float screenWidthPerc = 0.8f;
        final float screenHeightPerc = 0.6f;

        /*
        * Multiply the width and height by a percentage to determine how much the pop up window
        * cont. is going to take.
        * */
        getWindow().setLayout((int) (width * screenWidthPerc), (int) (height * screenHeightPerc));

    }


    /*
    * Button Listener functions
    * */
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.create_button:
                Log.d("create_button", "Executed");
                //TODO: Check for exceptions if user does not enter anything.

                //Get User Input
                inputFoodName = nameEditText.getText().toString();
                inputPortionSize = Float.parseFloat(portionsEditText.getText().toString());
                inputTotalServings = Integer.parseInt(servingsEditText.getText().toString());

                //Pass User inputs as arguments to the food container. Then pass food container to the refrigerator class.
                FoodItem foodItem = new FoodItem(inputFoodName, inputPortionSize, inputUnitMeasurements, inputTotalServings);

                //Add to Refrigerator Enum Singleton
                Refrigerator.FoodTypes instance;
                instance = Refrigerator.FoodTypes.valueOf(foodTypes.name());
                instance.add(foodItem.name, foodItem);

                //Add to ingredient Spinners
                AddIngredients.addToSpinners(foodItem.getName(), foodTypes);

                //closes activity
                this.finish();
                break;
            case R.id.cancel_button:
                Log.d(TAG, "\tcancel_button" + " Executed");
                this.finish();
                break;
            default:
                break;
        }
    }

    /* Spinner Listener Functions
    * */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView itemSelectedTxt = (TextView) view;
        Toast.makeText(this, "You Selected: " + itemSelectedTxt.getText(), Toast.LENGTH_SHORT).show();

        /*
        * Data: Strings
        * grams, ounces
        * */
        inputUnitMeasurements = itemSelectedTxt.getText().toString();
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
