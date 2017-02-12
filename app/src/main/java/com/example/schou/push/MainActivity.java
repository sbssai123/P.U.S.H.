package com.example.schou.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;


/**
 * Main page with buttons for navigating to Groups and Messages.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button groupButton;
    Button messagesButton;

    protected static String PREF_NAME = "MyPrefs";
    protected static String GROUPS = "Groups";

    private SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shared = getSharedPreferences(MainActivity.PREF_NAME, Context.MODE_PRIVATE);

        //new BsyncTask().execute();

        groupButton = (Button)findViewById(R.id.groupButton);
        groupButton.setOnClickListener(this);

        //messagesButton = (Button)findViewById(R.id.messagesButton);

        Set<String> groups = shared.getStringSet(GROUPS, new HashSet<String>());
        System.out.println("GROUPS: " + groups.toString());
        for (String group : groups) {
            Set<String> members = shared.getStringSet(group, new HashSet<String>());
            System.out.println(group + "  " + members.toString());
            for (String member : members) {
                String phone = shared.getString(member, "");
                System.out.println(member + ": " + phone);
            }
        }

    }
    private static final String KEY_TEXT_REPLY = "key_text_reply";

    private void addNotification() {
        Intent intent = new Intent(this, BsyncTask.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        android.support.v4.app.NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("P.U.S.H. Alert")
                        .setContentText("Are you in trouble?")
        .addAction(R.drawable.icon, "Yes", pIntent)
                        .setOngoing(true);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());


    }


    //When the button is clicked, go to the right page
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.groupButton) {
            Intent intent = new Intent(this, GroupActivity.class);
            startActivity(intent);
        }
        // to send persistent notification to the home screen
        if (view.getId() == R.id.activeButton) {
            addNotification();
        }
    }

}



