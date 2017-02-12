package com.example.schou.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import Group.Member;

/*
This page is for adding new Members. Users can add a Memver with a Name and a Phone Number.
There is an option to Save the data and return back to the Group page.
 */
public class NewMemberActivity extends AppCompatActivity implements View.OnClickListener {

    Button saveMember;
    //Member fields
    String name, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        saveMember = (Button)findViewById(R.id.saveMemberButton);
        saveMember.setOnClickListener(this);

    }

    //if Save Member is clicked, go back to the New Group Activity page
    //TODO make sure to save the Member and it should appear in the list of messages
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.saveMemberButton) {
            // todo validation

            EditText nameText = (EditText)findViewById(R.id.memberName);
            EditText phoneText = (EditText)findViewById(R.id.memberPhone);

            //gets the text of the name of the member
            name = nameText.getText().toString();

            //gets the number
            phone = phoneText.getText().toString();

            Member m = new Member(name, phone);
            GroupActivity.groupMembers.add(m);

            Intent intent = new Intent(this, NewGroupActivity.class);
            startActivity(intent);
        }
    }

}
