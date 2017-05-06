package edu.afigueroacogswell.whatsonthemenu;


import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;


public class CreatePlate extends AppCompatActivity implements View.OnClickListener
{

    private final String TAG = "CreatePlate";

    Button createPlateButton;

    TextView resultText;

    //FILTER SELECTIONS
    ArrayList<Refrigerator.FoodTypes> foodTypesSelection = new ArrayList<>();
    ArrayList<FoodItem.Tags> foodTagsSelection = new ArrayList<>();

    //region "ACTIVITY LIFECYCLE METHODS"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createplate);

        //TOOLBAR SET UP
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //BUTTON SET UP
        createPlateButton = (Button) findViewById(R.id.create_plate_button);
        createPlateButton.setOnClickListener(this);

        resultText = (TextView) findViewById(R.id.create_plate_result_text);
    }


    //Runs Everytime we Restart Application
    //Load SQL data here.
    @Override
    public void onStart()
    {
        super.onStart();
        Log.i(TAG, "Start State");

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


    //CLASS METHODS
    private void createPlate()
    {
        //For each item food type in the refrigerator.
        for(Refrigerator.FoodTypes type : foodTypesSelection)
        {
            //Do Stuff here since filter is done.
            //Check for tags in current type.
            tagFilter(type);

        }
    }

    //STILL IN PROGRESS.
    private void tagFilter(Refrigerator.FoodTypes currentType)
    {
        String foodEntry = "";

        //if the current type is empty.
        if (currentType.getFoodMap().isEmpty())
        {
            Toast.makeText(this, currentType.toString() + " is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        //For each map entry in the foodmap. Loop through each foodItem
        for (Map.Entry<String, FoodItem> entry: currentType.getFoodMap().entrySet())
        {
            //Loop through tags in the current foodItem. Loop through each food tag in FoodItem.
            for (int index = 0; index < entry.getValue().getTags().size(); index++)
            {
                //Loop through each foodTag in the foodTagSelection
                for(int counter = 0; counter < foodTagsSelection.size(); counter++)
                {
                    //Compare the current entry tag value with the all the tags in the foodtagsSelection
                    if(entry.getValue().getTags().get(index) != foodTagsSelection.get(counter))
                    {
                        return;
                    }
                    else
                    {
                        resultText.setText(entry.getValue().getName()); //gets the latest foodItem name. Replace with array.
                    }
                }
            }
        }
    }

    //CHECKBOX LISTENERS
    public void selectTags(View view)
    {
        //Checks individually if this view's check box has been checked.
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId())
        {
            case R.id.createplate_breakfast_tag:
                if(checked)
                {
                    foodTagsSelection.add(FoodItem.Tags.BREAKFAST);
                }
                else
                {
                    foodTagsSelection.remove(FoodItem.Tags.BREAKFAST);
                }

                break;
            case R.id.createplate_lunch_tag:
                if(checked)
                {
                    foodTagsSelection.add(FoodItem.Tags.LUNCH);
                }
                else
                {
                    foodTagsSelection.remove(FoodItem.Tags.LUNCH);
                }

                break;
            case R.id.createplate_dinner_tag:
                if(checked)
                {
                    foodTagsSelection.add(FoodItem.Tags.DINNER);
                }
                else
                {
                    foodTagsSelection.remove(FoodItem.Tags.DINNER);
                }
                break;
            case R.id.createplate_dessert_tag:
                if(checked)
                {
                    foodTagsSelection.add(FoodItem.Tags.DESSERT);
                }
                else
                {
                    foodTagsSelection.remove(FoodItem.Tags.DESSERT);
                }

                break;
            case R.id.createplate_snacks_tag:
                if(checked)
                {
                    foodTagsSelection.add(FoodItem.Tags.SNACKS);
                }
                else
                {
                    foodTagsSelection.remove(FoodItem.Tags.SNACKS);
                }

                break;
            case R.id.createplate_general_tag:
                if(checked)
                {
                    foodTagsSelection.clear();
                    foodTagsSelection.add(FoodItem.Tags.GENERAL);
                }
                else
                {
                    foodTagsSelection.remove(FoodItem.Tags.GENERAL);
                }

                break;

            default:
                if(checked)
                {
                    foodTagsSelection.clear();
                    foodTagsSelection.add(FoodItem.Tags.GENERAL);
                }
                else
                {
                    foodTagsSelection.remove(FoodItem.Tags.GENERAL);
                }
                break;
        }
    }

    public void selectFoodTypes(View view)
    {
        //Checks individually if this view's check box has been checked.
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId())
        {
            case R.id.dairy_checkbox:
                if(checked)
                {
                    foodTypesSelection.add(Refrigerator.FoodTypes.DAIRY);
                }
                else
                {
                    foodTypesSelection.remove(Refrigerator.FoodTypes.DAIRY);
                }

                break;
            case R.id.fruits_checkbox:
                if(checked)
                {
                    foodTypesSelection.add(Refrigerator.FoodTypes.FRUITS);
                }
                else
                {
                    foodTypesSelection.remove(Refrigerator.FoodTypes.FRUITS);
                }

                break;
            case R.id.starch_checkbox:
                if(checked)
                {
                    foodTypesSelection.add(Refrigerator.FoodTypes.STARCH);
                }
                else
                {
                    foodTypesSelection.remove(Refrigerator.FoodTypes.STARCH);
                }
                break;
            case R.id.proteins_checkbox:
                if(checked)
                {
                    foodTypesSelection.add(Refrigerator.FoodTypes.PROTEINS);
                }
                else
                {
                    foodTypesSelection.remove(Refrigerator.FoodTypes.PROTEINS);
                }

                break;
            case R.id.sugars_checkbox:
                if(checked)
                {
                    foodTypesSelection.add(Refrigerator.FoodTypes.SUGARS);
                }
                else
                {
                    foodTypesSelection.remove(Refrigerator.FoodTypes.SUGARS);
                }

                break;
            case R.id.vegetables_checkbox:
                if(checked)
                {
                    foodTypesSelection.add(Refrigerator.FoodTypes.VEGETABLES);
                }
                else
                {
                    foodTypesSelection.remove(Refrigerator.FoodTypes.VEGETABLES);
                }

                break;
            case R.id.liquids_checkbox:
                if(checked)
                {
                    foodTypesSelection.add(Refrigerator.FoodTypes.LIQUIDS);
                }
                else
                {
                    foodTypesSelection.remove(Refrigerator.FoodTypes.LIQUIDS);
                }

                break;
            case R.id.condiments_checkbox:
                if(checked)
                {
                    foodTypesSelection.add(Refrigerator.FoodTypes.CONDIMENTS);
                }
                else
                {
                    foodTypesSelection.remove(Refrigerator.FoodTypes.CONDIMENTS);
                }

                break;
            default:

                break;
        }
    }


    //BUTTON LISTENER
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.create_plate_button:
                createPlate();

                break;
            default:
                //TODO: Create a Toast for default state.

                break;
        }
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
            Toast.makeText(this, "Create Plate: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.home)
        {
            //takes me back to parent activity.
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }

}
