package com.example.schou.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Screen that shows a list of all saved Messages. Allows you to add a new Message, and click a
Message to select it as the current for the night.
 */
public class MessageActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        ImageButton addNewMsg = (ImageButton)findViewById(R.id.addNewMessageButton);
        addNewMsg.setOnClickListener(this);

        Set<String> messages = MainActivity.shared.getStringSet(MainActivity.MESSAGES, new HashSet<String>());
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message);
            sb.append("\n");
        }
        TextView listMessages = (TextView)findViewById(R.id.listOfMessages);
        listMessages.setText(sb.toString());

    }


    //if the add new message button is clicked, go to the new message page
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addNewMessageButton) {
            Intent intent = new Intent(this, NewMessageActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.doneMessages) {


            Intent intent = new Intent(this, MessageActivity.class);
            startActivity(intent);
        }
    }
}
