package com.example.schou.push;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Group.*;

/*
This page is for Groups. There is a list of Group Names, as well as the option to add new Groups
with the click of a button. If the user clicks on a Group, that is their selected Group for the
night. It should be changed to all caps.
 */
public class GroupActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemSelectedListener {

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

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Set<String> groupSet = shared.getStringSet(MainActivity.GROUPS, new HashSet<String>());
        String[] groups = groupSet.toArray(new String[groupSet.size()]);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                R.layout.drawer_list_item, groups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        TextView groupNameText = (TextView) findViewById(R.id.group_name);
        String groupName = groupNameText.getText().toString();

        if (groups.length > 0) {
            int defaultNum = 0;
            String defaultGroup = shared.getString(MainActivity.DEFAULT_GROUP, "");
            for (defaultNum = 0; defaultNum < groups.length; defaultNum++) {
                if (spinner.getItemAtPosition(defaultNum).equals(defaultGroup)) {
                    break;
                }
            }
            if (defaultNum == groups.length) {
                defaultNum = 0;
            }
            spinner.setSelection(defaultNum);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        String selection = (String) parent.getItemAtPosition(pos);
        TextView spinnerText = (TextView) findViewById(R.id.group_name);

        spinnerText.setText(selection);

        Set<String> mems = shared.getStringSet(selection, new HashSet<String>());

        TextView membersText = (TextView) findViewById(R.id.group_members);
        String str = "";
        for (String s : mems) {
            str += "\n" + s;
        }

        membersText.setText(str);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //When the button is clicked, go to the page to add a new Group
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addGroup) {
            Intent intent = new Intent(this, NewGroupActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.setDefaultGroup) {
            TextView groupNameText = (TextView) findViewById(R.id.group_name);
            String groupName = groupNameText.getText().toString();
            SharedPreferences.Editor editor = shared.edit();
            editor.putString(MainActivity.DEFAULT_GROUP, groupName);
            editor.commit();

            Intent intent = new Intent(this, GroupActivity.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.backButton) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

}
