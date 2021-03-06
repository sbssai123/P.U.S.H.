package com.example.code.push;

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


        EditText msgText = (EditText)findViewById(R.id.messageContent);

        boolean valid = true;

        if (msgText.length() == 0 ) {
            valid = false;
            msgText.requestFocus();
            msgText.setError("Message field cannot be empty");
        }

        if (v.getId() == R.id.saveMessageButton) {

            EditText newMessage = (EditText) findViewById(R.id.messageContent);
            String msg = newMessage.getText().toString();
            Set<String> allMessages = MainActivity.shared.getStringSet(MainActivity.MESSAGES, new HashSet<String>());
            allMessages.add(msg);
            Editor e = MainActivity.shared.edit();
            e.putStringSet(MainActivity.MESSAGES, allMessages);
            e.commit();

           //TODO get the data from the text box, and add the string to the AppData.messages hashmap
            //at int size + 1

            AppData.messages.put((Integer)(AppData.messages.size() + 1), msg);
            Intent intent = new Intent(this, MessageActivity.class);
            startActivity(intent);
        }
    }
}
