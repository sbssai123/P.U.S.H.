package com.example.schou.push;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
/*
Screen that shows a list of all saved Messages. Allows you to add a new Message, and click a
Message to select it as the current for the night.
 */
public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
    }

}
