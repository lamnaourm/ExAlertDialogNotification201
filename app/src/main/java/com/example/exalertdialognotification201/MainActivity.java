package com.example.exalertdialognotification201;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void affiche1(View view) {

        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Titre de message");
        alert.setMessage("Mon message .......");
        alert.setCancelable(false);
        alert.setIcon(R.drawable.icon);

        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "OKKK", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "NOOOOO", Toast.LENGTH_SHORT).show();

            }
        });

        alert.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "CANCEL .....", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }

    public void affiche2(View view) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            Notification.Builder n = new Notification.Builder(MainActivity.this);
            n.setContentTitle("Alerte de test");
            n.setContentText("Message de mon alerte ");
            n.setSmallIcon(R.drawable.icon);
            n.setDefaults(Notification.DEFAULT_SOUND);

            NotificationManager mNotification = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            mNotification.notify(1, n.build());
        } else {
            String CHANNEL_ID = CHANNEL_ID = "my_channel_01";// The id of the channel.
            CharSequence name = "CHANNEL NEW NAME";// The user-visible name of the channel.
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = mChannel = new NotificationChannel(CHANNEL_ID, name, importance);

            Notification notification = new Notification.Builder(MainActivity.this)
                    .setContentTitle("New Message")
                    .setContentText("You've received new messages.")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setChannelId(CHANNEL_ID)
                    .build();
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.createNotificationChannel(mChannel);
            mNotificationManager.notify(1, notification);

        }

    }
}