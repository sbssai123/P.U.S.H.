package com.example.schou.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import Group.Group;

public class GroupActivity extends AppCompatActivity implements View.OnClickListener {

    private Group tonightsGroup;
    private List<Group> favoriteGroups;
    private List<Group> otherGroups;

    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        addButton = (Button)findViewById(R.id.button);
        addButton.setOnClickListener(this);
    }

    //add a new Group with Name and Members
    public void addGroup() {

    }

    //delete selected Group
    public void deleteGroup() {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            Intent intent = new Intent(this, NewGroupActivity.class);
            startActivity(intent);
        }
    }
}
