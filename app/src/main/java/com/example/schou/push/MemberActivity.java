package com.example.schou.push;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MemberActivity extends AppCompatActivity {

    private String name;
    private int number; //todo should the number be an int? or a string? or a float? idk

    public MemberActivity(String n, int num) {
        this.name = n;
        this.number = num;
    }

    public void setMemberName(String n) {
        this.name = n;
    }

    public void setMemberNumber(int n) {
        this.number = n;
    }

    public String getName() {
        return this.name;
    }
    public int getNumber() {
        return this.number;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
    }
}
