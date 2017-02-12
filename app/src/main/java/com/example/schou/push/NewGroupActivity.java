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
        back = (Button)findViewById(R.id.backToGroupsButton);

        listOfMembers = (ListView)findViewById(R.id.listOfMembers);

        addGroupButton.setOnClickListener(this);
        back.setOnClickListener(this);

        //todo change this!!
        AppData.members[0].put("joe", 123);
        //update what is in the hashmap at 0 and change it to uppercase to notify users of
        //the current group chosen
        AppData.groups.put(0, AppData.groups.get(0).toString().toUpperCase());
    }


    // adds the group to sharedPreference
    // todo change this
    // overwrites if group already exists, (empty string is also valid)
    private void addMembers() {
        EditText groupNameText = (EditText) findViewById(R.id.groupName);
        String groupName = groupNameText.toString();
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

    //When the Add button is clicked, go to the page to add a new Member
    //When the back button is clicked, save and return to the Group page
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addMemberButton) {
            //EditText memberName = (EditText) findViewById(R.id.)

            Intent intent = new Intent(this, NewMemberActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.backToGroupsButton) {
            //todo get the group info.
            //add all the members to the AppData.members hash
            addMembers();
            Intent intent = new Intent(this, GroupActivity.class);
            startActivity(intent);
        }
    }
}
