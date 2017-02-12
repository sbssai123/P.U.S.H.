package com.example.schou.push;

import android.content.Intent;
import android.content.SharedPreferences.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashSet;
import java.util.Set;

/*
Screen for adding a new Message that has a Text Box, and a Save/Back button.
 */
public class NewMessageActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        Button saveMessageButton = (Button)findViewById(R.id.saveMessageButton);
        saveMessageButton.setOnClickListener(this);
    }


    //if the saveMessageButton is clicked, go back to the Message Activity page
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.saveMessageButton) {

            EditText newMessage = (EditText) findViewById(R.id.messageContent);
            String str = newMessage.getText().toString();
            Set<String> allMessages = MainActivity.shared.getStringSet(MainActivity.MESSAGES, new HashSet<String>());
            allMessages.add(str);
            Editor e = MainActivity.shared.edit();
            e.putStringSet(MainActivity.MESSAGES, allMessages);
            e.commit();

            Intent intent = new Intent(this, MessageActivity.class);
            startActivity(intent);
        }
    }
}
