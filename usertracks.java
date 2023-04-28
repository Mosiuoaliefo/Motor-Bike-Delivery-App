package com.example.wedeliver;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class usertracks extends AppCompatActivity {
    Button notifyBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usertracks);
        notifyBtn = findViewById(R.id.notify_btn);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel Channel = new NotificationChannel("My notification", "My notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(Channel);
        }

        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(usertracks.this, "My notification");
                builder.setContentTitle("WE DELIVER");
                builder.setContentText("Mosiuoa Liefo Sent Your Iterms...  ");
                builder.setSmallIcon(R.drawable.food);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(usertracks.this);
                managerCompat.notify(1, builder.build());
                Toast.makeText(usertracks.this, "Sending Notification", Toast.LENGTH_SHORT).show();

            }

        });
           /* Intent intent = new Intent(usertracks.this, usertracks.class);
            Toast.makeText(this, "Sending Notification", Toast.LENGTH_SHORT).show();
            startActivity(intent);*/
    }
   /* public void gotobikes(View view){
        Intent intent = new Intent(usertracks.this, usertracks.class);
        Toast.makeText(this, "Sent", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }*/

    public void tracks(View view) {
        Intent intent = new Intent(usertracks.this, TrackedOrders.class);
        Toast.makeText(this, "tracked", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }
}