package com.example.schou.push;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import Group.*;

/*
This page is for Groups. There is a list of Group Names, as well as the option to add new Groups
with the click of a button. If the user clicks on a Group, that is their selected Group for the
night. It should be changed to all caps.
 */
public class GroupActivity extends AppCompatActivity implements View.OnClickListener {

    Button addGroupButton;
    private SharedPreferences shared;

    protected static List<Member> groupMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        shared = getSharedPreferences(MainActivity.PREF_NAME, Context.MODE_PRIVATE);
        if (shared.getStringSet(MainActivity.GROUPS, new HashSet<String>()).equals(new HashSet<String>())) {
            SharedPreferences.Editor editor = shared.edit();
            editor.putStringSet(MainActivity.GROUPS, new HashSet<String>());
            editor.commit();
        }

        SharedPreferences.Editor editor = shared.edit();

        groupMembers = new LinkedList<Member>();

        //todo change this so that it is the one they clicked on, but for now it is the last one
        /*AppData.currentGroup = AppData.groups.size();
        int cg = AppData.currentGroup;
        //put a new String at the currentGroup value that is all caps.
        AppData.groups.put(cg, AppData.groups.get(cg).toString().toUpperCase());*/

        //groups = new LinkedList<String>();

    }

    //When the button is clicked, go to the page to add a new Group
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.createGroupButton) {
            Intent intent = new Intent(this, NewGroupActivity.class);
            startActivity(intent);
        }
    }

}
