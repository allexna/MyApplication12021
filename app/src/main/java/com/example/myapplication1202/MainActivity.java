package com.example.myapplication1202;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class MainActivity extends AppCompatActivity {
    private static final int NOTIFY_ID=101;
    private static final String CHANNEL_ID="Cat channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notificationIntent=new Intent(MainActivity.this,MainActivity.class);
                PendingIntent contentIntent=PendingIntent.getActivity(MainActivity.this,0,notificationIntent,PendingIntent.FLAG_CANCEL_CURRENT);
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_pets_black_24dp)
                        .setContentTitle("Напоминание")
                        .setContentText("Пора кормить кота")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(contentIntent)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.cat))
                        .setTicker("LAST NOTE!")
                        .setAutoCancel(true);
                NotificationManagerCompat notificationManager=NotificationManagerCompat.from(MainActivity.this);
            notificationManager.notify(NOTIFY_ID,builder.build());}
        });
    }
}
