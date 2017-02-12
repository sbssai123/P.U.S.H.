package com.example.schou.push;

/**
 * Class to represent a Member. A Member has a Name and a Phone Number.
 */

public class Member {
    private String name;
    private int number; //todo should the number be an int? or a string? or a float? idk

    public Member(String n, int num) {
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
}
