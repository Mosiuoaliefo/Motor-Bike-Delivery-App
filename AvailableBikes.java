package com.example.wedeliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AvailableBikes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avalable_bikes);
    }
    public void gotobikes(View view){
        Intent intent = new Intent(AvailableBikes.this, DeliveryServices.class);
        Toast.makeText(this, "Bike selected successfully", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}