package com.example.schou.push;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Main page with buttons for navigating to Groups and Messages.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button groupButton;
    Button messagesButton;

    protected static String PREF_NAME = "MyPrefs";
    protected static String GROUPS = "Groups";

    private SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new BsyncTask().execute();

        groupButton = (Button)findViewById(R.id.groupButton);
        groupButton.setOnClickListener(this);

        messagesButton = (Button)findViewById(R.id.messagesButton);

    }


    //When the button is clicked, go to the right page
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.groupButton) {
            Intent intent = new Intent(this, GroupActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.messagesButton) {
            Intent intent = new Intent(this, MessageActivity.class);
            startActivity(intent);
        }
    }

}



