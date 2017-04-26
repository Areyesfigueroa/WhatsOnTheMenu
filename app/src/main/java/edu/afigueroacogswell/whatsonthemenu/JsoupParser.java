package edu.afigueroacogswell.whatsonthemenu;

import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupParser extends AppCompatActivity{

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

        parseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new ParseHtml().execute();
            }
        });
    }


    public class ParseHtml extends AsyncTask<Void, Void ,Void>
    {
        String words;

        @Override
        protected Void doInBackground(Void... params) {

            try {
                Document doc = Jsoup.connect("http://www.javaworld.com/article/2076970/core-java/create-enumerated-constants-in-java.html").get();

                words = doc.text();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            parseText.setText(words);
        }
    }
}
