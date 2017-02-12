package com.example.schou.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import Group.Group;

/*
This page is for Groups. There is a list of Groups, as well as the option to add new Groups with the
click of a button.
 */
public class GroupActivity extends AppCompatActivity implements View.OnClickListener {

    Button addGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        addGroupButton = (Button)findViewById(R.id.addGroupButton);
        addGroupButton.setOnClickListener(this);
    }

    //When the button is clicked, go to the page to add a new Group
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addGroupButton) {
            Intent intent = new Intent(this, NewGroupActivity.class);
            startActivity(intent);
        }
    }
}
