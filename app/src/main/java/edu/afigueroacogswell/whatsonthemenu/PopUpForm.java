package edu.afigueroacogswell.whatsonthemenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/*
* TODO:
* Debug Log:
* */
public class PopUpForm extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener
{
    //region "GLOBAL VARIABLES"
   // public static String headerString;
    public static Refrigerator.FoodTypes foodTypes;

    //Debugging
    private final String TAG = "PopUpForm";

    TextView headerText;

    //Input Content
    EditText nameEditText;
    EditText portionsEditText;
    EditText servingsEditText;

    //Spinner Variable
    FoodItem.Units inputUnitMeasurements;

    //Buttons
    Button createButton;
    Button cancelButton;

    //Spinner
    Spinner unitSpinner;
    Spinner tagSpinner;

    //CHECKBOX SETUP
    CheckBox breakfast;
    CheckBox lunch;
    CheckBox dinner;
    CheckBox dessert;
    CheckBox snacks;
    CheckBox general;

    ArrayList<FoodItem.Tags> selectionTags = new ArrayList<FoodItem.Tags>();

    //endregion "GLOBAL VARIABLES"

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupform);

        //region "SET UP CHECKBOX"
        breakfast = (CheckBox) findViewById(R.id.breakfast_tag);
        lunch = (CheckBox) findViewById(R.id.lunch_tag);
        dinner = (CheckBox) findViewById(R.id.dinner_tag);
        dessert = (CheckBox) findViewById(R.id.dessert_tag);
        snacks = (CheckBox) findViewById(R.id.snacks_tag);
        general = (CheckBox) findViewById(R.id.general_tag);

        //Set Checkbox Text
        breakfast.setText(FoodItem.Tags.BREAKFAST.getStringID());
        lunch.setText(FoodItem.Tags.LUNCH.getStringID());
        dinner.setText(FoodItem.Tags.DINNER.getStringID());
        dessert.setText(FoodItem.Tags.DESSERT.getStringID());
        snacks.setText(FoodItem.Tags.SNACKS.getStringID());
        general.setText(FoodItem.Tags.GENERAL.getStringID());
        //endregion "SET UP CHECKBOX"


        //region "SET UP HEADER FOR FORM"
        headerText = (TextView) findViewById(R.id.form_header_text);
        headerText.setText(foodTypes.toString());

        //endregion "SET UP HEADER FOR FORM"


        //region "SET FORM INPUT VARIABLES"
        nameEditText = (EditText) findViewById(R.id.input_ingredient_name_text);
        portionsEditText= (EditText) findViewById(R.id.input_portions);
        servingsEditText = (EditText) findViewById(R.id.input_servings);

        //endregion "SET FORM INPUT VARIABLES"


        //region "SPINNER SET-UP"
        unitSpinner = (Spinner) findViewById(R.id.unit_spinner);

        //endregion "SPINNER SET-UP"


        //region "ADAPTER SET-UP"
        ArrayAdapter<FoodItem.Units> adapter = new ArrayAdapter<FoodItem.Units>(this, R.layout.support_simple_spinner_dropdown_item, FoodItem.Units.values());
        unitSpinner.setAdapter(adapter);
        unitSpinner.setOnItemSelectedListener(this);

        //endregion "ADAPTER SET-UP"


        //region "BUTTON SET-UP"
        createButton = (Button) findViewById(R.id.create_button);
        cancelButton = (Button) findViewById(R.id.cancel_button);


        createButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        //endregion "BUTTON SET-UP"


        //region "POP UP WINDOW SET-UP"
        //Contains the width and height of the screen
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width = dm.widthPixels;
        int height = dm.heightPixels;


        final float screenWidthPerc = 0.8f;
        final float screenHeightPerc = 0.6f;


        //Multiply the width and height by a percentage to determine how much the pop up window
        //cont. is going to take.
        getWindow().setLayout((int) (width * screenWidthPerc), (int) (height * screenHeightPerc));

        //endregion "POP UP WINDOW SET-UP"
    }



    public void selectItem(View view)
    {
        //Checks individually if this view's check box has been checked.
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId())
        {
            case R.id.breakfast_tag:
                if(checked)
                {
                    selectionTags.add(FoodItem.Tags.BREAKFAST);
                }
                else
                {
                    selectionTags.remove(FoodItem.Tags.BREAKFAST);
                }

                break;
            case R.id.lunch_tag:
                if(checked)
                {
                    selectionTags.add(FoodItem.Tags.LUNCH);
                }
                else
                {
                    selectionTags.remove(FoodItem.Tags.LUNCH);
                }

                break;
            case R.id.dinner_tag:
                if(checked)
                {
                    selectionTags.add(FoodItem.Tags.DINNER);
                }
                else
                {
                    selectionTags.remove(FoodItem.Tags.DINNER);
                }
                break;
            case R.id.dessert_tag:
                if(checked)
                {
                    selectionTags.add(FoodItem.Tags.DESSERT);
                }
                else
                {
                    selectionTags.remove(FoodItem.Tags.DESSERT);
                }

                break;
            case R.id.snacks_tag:
                if(checked)
                {
                    selectionTags.add(FoodItem.Tags.SNACKS);
                }
                else
                {
                    selectionTags.remove(FoodItem.Tags.SNACKS);
                }

                break;
            case R.id.general_tag:
                if(checked)
                {
                    selectionTags.clear();
                    selectionTags.add(FoodItem.Tags.GENERAL);
                }
                else
                {
                    selectionTags.remove(FoodItem.Tags.GENERAL);
                }

                break;

            default:
                if(checked)
                {
                    selectionTags.clear();
                    selectionTags.add(FoodItem.Tags.GENERAL);
                }
                else
                {
                    selectionTags.remove(FoodItem.Tags.GENERAL);
                }
                break;
        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.create_button:
                //DEBUG
                Log.d(TAG, "create_button" + " Executed");

                //Get User Input
                String inputFoodName = nameEditText.getText().toString();
                float inputPortionSize = Float.parseFloat(portionsEditText.getText().toString());
                int inputTotalServings = Integer.parseInt(servingsEditText.getText().toString());

                //Pass User inputs as arguments to the food container. Then pass food container to the refrigerator class.
                FoodItem foodItem = new FoodItem(inputFoodName, inputPortionSize, inputTotalServings, inputUnitMeasurements , selectionTags);


                //Add to Refrigerator Enum Singleton
                Refrigerator.FoodTypes instance;
                instance = Refrigerator.FoodTypes.valueOf(foodTypes.name());
                instance.add(foodItem.name, foodItem);


                //Set refrigerator history.
                Refrigerator.getInstance().setLatestFoodItem(foodItem);
                Refrigerator.getInstance().setLatestFoodType(foodTypes);


                //Debug logs
                Refrigerator.getInstance().printRefrigerator();


                //closes activity
                this.finish();


                break;
            case R.id.cancel_button:
                Log.d(TAG, "\tcancel_button" + " Executed");
                Refrigerator.getInstance().setLatestFoodType(Refrigerator.FoodTypes.NONE);

                this.finish();


                break;
            default:
                //TODO: Create a Toast for default state.

                break;
        }
    }


    //Spinner Listener Methods
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //TextView itemSelectedTxt = (TextView) view;

        switch (FoodItem.Units.values()[position])
        {
            case GRAMS:
                inputUnitMeasurements = FoodItem.Units.GRAMS;

                break;
            case OUNCES:
                inputUnitMeasurements = FoodItem.Units.OUNCES;

                break;
            default:
                break;

        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}
