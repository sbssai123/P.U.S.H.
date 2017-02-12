package com.example.schou.push;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class NeedHelpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BsyncTask bysncTask = new BsyncTask();
        bysncTask.execute();
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}
