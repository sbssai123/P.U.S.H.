package com.example.schou.push;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class NeedHelpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.need_help);
        new BsyncTask().execute();
        Log.d("MADE IT", "HERE");
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}
