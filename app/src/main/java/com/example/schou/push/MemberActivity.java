package com.example.schou.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MemberActivity extends AppCompatActivity implements View.OnClickListener {

    Button saveMember;
    //Member fields
    EditText name, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        saveMember = (Button)findViewById(R.id.saveMemberButton);
        saveMember.setOnClickListener(this);
        name = (EditText)findViewById(R.id.memberName);
        phone = (EditText)findViewById(R.id.memberPhone);

        //gets the text of the name of the member
        name.getText().toString();

        //gets the number
        phone.getText().toString();
    }

    //if Save Member is clicked, go back to the New Group Activity page
    //TODO make sure to save the Member and it should appear in the list of messages
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.saveMemberButton) {
            Intent intent = new Intent(this, NewGroupActivity.class);
            startActivity(intent);
        }
    }

}
