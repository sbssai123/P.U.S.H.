package com.example.schou.push;

import java.util.HashMap;

/**
 * Class for App Data: Hashmaps to store information.
 */

public class AppData {
    //members is the array of Members in a group. Maps a String name to an Integer Phone number.
    public static HashMap<String, Integer> members[] = new HashMap[10];

    //groups is a hashmap from Group ID number to String Group Name.
    public static HashMap<Integer, String> groups = new HashMap<>();

    //messages is a hashmap from ID number to String message.
    public static HashMap<Integer, String> messages = new HashMap<>();

    //the ID of the current group, as selected by the user. Used to replace this key in the hash
    //with a new UPPERCASE value
    public static int currentGroup;

    //the ID of the current message, as selected by the user. Used to replace this key in the hash
    //with a new UPPERCASE value
    public static int currentMessage;

}
