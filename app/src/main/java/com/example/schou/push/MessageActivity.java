package com.example.schou.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;
/*
Screen that shows a list of all saved Messages. Allows you to add a new Message, and click a
Message to select it as the current for the night.
 */
public class MessageActivity extends AppCompatActivity implements View.OnClickListener {

    Button addNewMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        addNewMsg = (Button)findViewById(R.id.addNewMessageButton);
        addNewMsg.setOnClickListener(this);
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
