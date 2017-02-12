package com.example.schou.push;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Group.Member;

/*
Screen that shows a list of all saved Messages. Allows you to add a new Message, and click a
Message to select it as the current for the night.
 */
public class MessageActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemSelectedListener {

    private SharedPreferences shared = MainActivity.shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        shared = getSharedPreferences(MainActivity.PREF_NAME, Context.MODE_PRIVATE);
        if (shared.getStringSet(MainActivity.GROUPS, new HashSet<String>()).equals(new HashSet<String>())) {
            SharedPreferences.Editor editor = shared.edit();
            editor.putStringSet(MainActivity.GROUPS, new HashSet<String>());
            editor.commit();
        }

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        Set<String> messageSet = shared.getStringSet(MainActivity.MESSAGES, new HashSet<String>());
        String[] messages = messageSet.toArray(new String[messageSet.size()]);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                R.layout.drawer_list_item, messages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        if (messages.length > 0) {
            int defaultNum = 0;
            String defaultMessage = MainActivity.shared.getString(MainActivity.DEFAULT_MESSAGE, "");
            for (defaultNum = 0; defaultNum < messages.length; defaultNum++) {
                if (spinner.getItemAtPosition(defaultNum).equals(defaultMessage )) {
                    break;
                }
            }
            if (defaultNum == messages.length) {
                defaultNum = 0;
            }
            spinner.setSelection(defaultNum);
        }
        /*
        ImageButton addNewMsg = (ImageButton)findViewById(R.id.addNewMessageButton);
        addNewMsg.setOnClickListener(this);

        Set<String> messages = MainActivity.shared.getStringSet(MainActivity.MESSAGES, new HashSet<String>());
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message);
            sb.append("\n");
        }
        TextView listMessages = (TextView)findViewById(R.id.listOfMessages);
        listMessages.setText(sb.toString());
*/
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        String selection = (String) parent.getItemAtPosition(pos);
        TextView spinnerText = (TextView) findViewById(R.id.message_head);

        spinnerText.setText(selection);

        Set<String> mems = MainActivity.shared.getStringSet(selection, new HashSet<String>());

        TextView membersText = (TextView) findViewById(R.id.message_text);
        String str = "";
        for (String s : mems) {
            str += "\n" + s;
        }

        membersText.setText(str);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    //if the add new message button is clicked, go to the new message page
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addNewMessageButton) {
            Intent intent = new Intent(this, NewMessageActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.setDefaultMessage) {
            TextView messageText = (TextView) findViewById(R.id.message_head);
            String message = messageText.getText().toString();
            SharedPreferences.Editor editor = MainActivity.shared.edit();
            editor.putString(MainActivity.DEFAULT_MESSAGE, message);
            editor.commit();

            Intent intent = new Intent(this, MessageActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.backButton2) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
