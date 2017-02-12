package com.example.schou.push;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MemberActivity extends AppCompatActivity {

    EditText name, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        name = (EditText)findViewById(R.id.memberName);
        phone = (EditText)findViewById(R.id.memberPhone);

        name.getText().toString();
    }
}
