package edu.afigueroacogswell.whatsonthemenu;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Ref;
import java.util.HashMap;
import java.util.Map;

public class NavigationDrawerFragment extends ListFragment implements AdapterView.OnItemClickListener{

    /*Global Variables
    * */
    public static final String PREF_FILE_NAME = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private final String TAG = "NavigationDrawerFragment";

    Button addIngredientNavButton;
    Button createNavButton;
    Button searchNavButton;
    Button jsoupNavButton;

    String[] testingTitleArr;

    /*Depending on these values we will close and open the drawer
    * */
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private View containerView;

    //Navigation Menu Button ID Constants
    private final int ADDINGREDIENTS = 0;
    private final int CREATEMENU = 1;
    private final int SEARCH = 2;
    private final int JSOUPPARSER = 3;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Populate lis with static array of titles
        //setListAdapter();

        //Check if the user has opened the drawer.
        mUserLearnedDrawer = Boolean.getBoolean(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
        if(savedInstanceState != null)
        {
            mFromSavedInstanceState = true;
        }
    }

    /*Built-in functions
    * */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        //Get a pointer to the layout.
        //From the layout get a reference to the buttons.

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.navigation_drawer,android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        switch (i)
        {
            case ADDINGREDIENTS:
                Toast.makeText(getActivity(), "AddIngredients Button Nav " +i, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(NavigationDrawerFragment.this.getActivity(), AddIngredients.class));


                break;
            case CREATEMENU:
                Toast.makeText(getActivity(), "Create Menu Button Nav (NOT READY)" +i, Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(NavigationDrawerFragment.this.getActivity(), AddIngredients.class));


                break;
            case SEARCH:
                Toast.makeText(getActivity(), "Search Button Nav (NOT READY) " +i, Toast.LENGTH_SHORT).show();


                break;
            case JSOUPPARSER:
                Toast.makeText(getActivity(), "Jsoup Parser Button Nav " +i, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(NavigationDrawerFragment.this.getActivity(), JsoupParser.class));


                break;
        }
    }

    /*App Functions
    * */
    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolBar)
    {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolBar, R.string.drawer_open, R.string.drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                if(!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer+"");
                }
                //Makes activity action bar draw again.
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                if(slideOffset < 0.6)
                {
                    toolBar.setAlpha(1- slideOffset);
                }
            }
        };

        if(!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(containerView);
        }

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }
    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }
    public static String readFromPreferences(Context context, String preferenceName, String defaultValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaultValue);
    }
}
