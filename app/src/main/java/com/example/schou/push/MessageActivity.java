package com.example.schou.push;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MessageActivity extends AppCompatActivity {

    private String tonightsMsg;
    private List<String> favoriteMsgs;
    private List<String> otherMsgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
    }

    //add new message - should have a text box appear for them to type msg
    public void addMessage() {

    }

    //delete selected message
    public void deleteMessage() {

    }
}
