package com.example.code.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
List of the Members in the Group. When the Group is clicked on in the GroupActivity page, it leads
to here, where the list of Members is shown. There is a button to add new members, and a back button
to return to the Group List Page.
 */
public class MembersInGroupActivity extends AppCompatActivity implements View.OnClickListener {

    Button addNewMem;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members_in_group);

        addNewMem = (Button)findViewById(R.id.addNewMem);
        addNewMem.setOnClickListener(this);

        backButton = (Button)findViewById(R.id.backToGroups);
        backButton.setOnClickListener(this);
    }

    //If the addNewMem button is clicked, direct back to the Member Activity Page.
    //If the back button is clicked, go back to the Group Activity Page.
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addNewMem) {
            Intent intent = new Intent(this, NewMemberActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.backToGroups) {
            Intent intent = new Intent(this, GroupActivity.class);
            startActivity(intent);
        }
    }

}
