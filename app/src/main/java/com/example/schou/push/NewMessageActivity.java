package com.example.schou.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
Screen for adding a new Message that has a Text Box, and a Save/Back button.
 */
public class NewMessageActivity extends AppCompatActivity implements View.OnClickListener {

    Button saveMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        saveMessageButton = (Button)findViewById(R.id.saveMessageButton);
        saveMessageButton.setOnClickListener(this);
    }


    //if the saveMessageButton is clicked, go back to the Message Activity page\
    //TODO make sure to save the message and it should appear in the list of messages
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.saveMessageButton) {
            //TODO get the data from the text box, and add the string to the AppData.messages hashmap
            //at int size + 1
            Intent intent = new Intent(this, MessageActivity.class);
            startActivity(intent);
        }
    }
}
