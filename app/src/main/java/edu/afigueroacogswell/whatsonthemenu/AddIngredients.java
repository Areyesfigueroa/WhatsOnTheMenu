package edu.afigueroacogswell.whatsonthemenu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/*
* TODO: Create the Toolbar so that it can display on every activity.
*
* Debug Log:
* Activity kept crashing because it needed to be implemented or called in the
* android mainfest file
* */
public class AddIngredients extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /*Global References
    * */
    Spinner spinner;
    Button createSpinnerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_ingredients);


        /*
        * Button SetUp
        * */

        createSpinnerButton = (Button) findViewById(R.id.createSpinnerButton);

        /*
        * Toolbar set up
        * */
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); // Delete this
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Delete this


        /*Spinner Prototype Initialization & Adapter Set Up
        * */
        spinner = (Spinner) findViewById(R.id.Proteins); //get spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.ProteinsArray, R.layout.support_simple_spinner_dropdown_item); // how to view the slider
        spinner.setAdapter(adapter); //set the adpater for the spinner
        spinner.setOnItemSelectedListener(this); //Stating which class is responsible for handling the listeners.
    }


    /*
    * Handles the Menu Creation set up.
    * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_addingredients, menu);
        return true;
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
