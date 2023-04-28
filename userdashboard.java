package com.example.wedeliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class userdashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdashboard);
    }
    public void gotobikes(View view){
        Intent intent = new Intent(userdashboard.this, AvailableBikes.class);
        Toast.makeText(this, "Searching Bikes", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

}