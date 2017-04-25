package edu.afigueroacogswell.whatsonthemenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JsoupParser extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = "JsoupParser";

    TextView parseText;
    Button parseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsouptest);

        parseText = (TextView) findViewById(R.id.parse_text);
        parseButton = (Button) findViewById(R.id.parse_button);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.parse_button:
                Log.i(TAG, "Parse Button Executed");



                break;
        }
    }
}
