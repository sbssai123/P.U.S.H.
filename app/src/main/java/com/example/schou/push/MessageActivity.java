package com.example.schou.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
/*
Screen that shows a list of all saved Messages. Allows you to add a new Message, and click a
Message to select it as the current for the night.
 */
public class MessageActivity extends AppCompatActivity implements View.OnClickListener {

    Button addNewMsg;
    ListView listOfMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        addNewMsg = (Button)findViewById(R.id.addNewMessageButton);
        addNewMsg.setOnClickListener(this);

        listOfMessages = (ListView)findViewById(R.id.listOfMessages);

        //todo change this, right now it is just the last one in the list as the current, we want
        //todo it to be the one the user selects.
        AppData.currentMessage = AppData.messages.size();
        int cm = AppData.currentMessage;
        // update what is in the hashmap at the currentMessage ID and change it to uppercase to
        // notify users of the current message chosen
        AppData.messages.put(cm, AppData.messages.get(cm).toString().toUpperCase());
    }


    //if the add new message button is clicked, go to the new message page
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addNewMessageButton) {
            Intent intent = new Intent(this, NewMessageActivity.class);
            startActivity(intent);
        }
    }
}
