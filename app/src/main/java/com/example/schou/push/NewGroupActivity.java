package com.example.schou.push;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Group.Member;

public class NewGroupActivity extends AppCompatActivity implements View.OnClickListener{
    Button addGroupButton;
    Button back;
    ListView listOfMembers;

    private SharedPreferences shared;

    protected static String memberArray = "groupMembers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        shared = getSharedPreferences(MainActivity.PREF_NAME, Context.MODE_PRIVATE);

        addGroupButton = (Button)findViewById(R.id.addMemberButton);

        listOfMembers = (ListView)findViewById(R.id.listOfMembers);

        addGroupButton.setOnClickListener(this);


        displayMembers();
    }


    // displays the currently entered members of the group
    private void displayMembers() {
        TextView membersList = (TextView) findViewById(R.id.addMembers);
        String str = "";
        for (Member m : GroupActivity.groupMembers) {
            str += "\n" + m.getName();
        }
        membersList.setText(str);
    }

    // adds the group to sharedPreference
    // todo change this
    // overwrites if group already exists, (empty string is also valid)
    private void addMembers() {
        EditText groupNameText = (EditText) findViewById(R.id.groupName);
        String groupName = groupNameText.getText().toString();
        Set<String> memberNames = new HashSet<String>();
        SharedPreferences.Editor editor = shared.edit();
        // add to groups
        Set<String> groups = shared.getStringSet(MainActivity.GROUPS, new HashSet<String>());
        groups.add(groupName);
        editor.putStringSet(MainActivity.GROUPS, groups);
        for (Member m : GroupActivity.groupMembers) {
            memberNames.add(m.getName());
            // adds members -> phone numbers
            editor.putString(m.getName(), m.getNumber());
        }
        // adds groupname -> members
        editor.putStringSet(groupName, memberNames);
        editor.commit();
    }

    // assigns a default if there exists none
    private void checkDefault() {
        if (shared.getString(MainActivity.DEFAULT_GROUP, "").equals("")) {
            EditText groupNameText = (EditText) findViewById(R.id.groupName);
            String groupName = groupNameText.getText().toString();
            SharedPreferences.Editor editor = shared.edit();
            editor.putString(MainActivity.DEFAULT_GROUP, groupName);
            editor.commit();
        }
    }

    //When the Add button is clicked, go to the page to add a new Member
    //When the back button is clicked, save and return to the Group page
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addMemberButton) {
            Intent intent = new Intent(this, NewMemberActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.validateGroup) {
            addMembers();
            checkDefault();
            Intent intent = new Intent(this, GroupActivity.class);
            startActivity(intent);
        }
    }
}
