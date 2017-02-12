package com.example.schou.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class NewGroupActivity extends AppCompatActivity implements View.OnClickListener{
    Button addGroupButton;
    Button back;
    ListView listOfMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        addGroupButton = (Button)findViewById(R.id.addMemberButton);
        back = (Button)findViewById(R.id.backToGroupsButton);

        listOfMembers = (ListView)findViewById(R.id.listOfMembers);

        addGroupButton.setOnClickListener(this);
        back.setOnClickListener(this);

        //todo change this!!
        //AppData.members[0].put("joe", 123);
        //update what is in the hashmap at 0 and change it to uppercase to notify users of
        //the current group chosen
        AppData.groups.put(0, AppData.groups.get(0).toString().toUpperCase());
    }


    //When the Add button is clicked, go to the page to add a new Member
    //When the back button is clicked, save and return to the Group page
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addMemberButton) {
            Intent intent = new Intent(this, NewMemberActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.backToGroupsButton) {
            //todo get the group info.
            //add all the members to the AppData.members hash

            Intent intent = new Intent(this, GroupActivity.class);
            startActivity(intent);
        }
    }
}
