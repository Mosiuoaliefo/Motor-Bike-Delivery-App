package com.example.wedeliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DeliveryServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_services);
    }
    public void gotobikes(View view) {
        Intent intent = new Intent(DeliveryServices.this, usertracks.class);
        Toast.makeText(this, "Service Selected Successfully", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }
}