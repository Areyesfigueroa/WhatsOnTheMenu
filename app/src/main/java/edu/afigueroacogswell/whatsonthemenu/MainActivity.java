package edu.afigueroacogswell.whatsonthemenu;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity{

    //Variables
    private final String TAG = "MainActivity";

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_appbar);


        //Finds the toolbar object and sets it to be the new action bar not the default one.
        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); // Delete this
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // delete this


        //NAVIGATION DRAWER INITIALIZATION
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        /*
        * Inflate the menu; this adds items to the actions/tools bar if it is present
        * */
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    /* This function handles all of the button inputs for the menu layout
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

        if (id == R.id.main_menu_action_settings)
        {
            Toast.makeText(this, "Hey you just hit" + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.navigate)
        {
            //changes activity by pressing the navigate buttons which is located on the tool bar.
            startActivity(new Intent(this, AddIngredients.class));
        }

        return super.onOptionsItemSelected(item);
    }
}

