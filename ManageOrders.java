package com.example.wedeliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ManageOrders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_orders);
    }

    public void gotomanagement(View view){
        Intent intent = new Intent(ManageOrders.this, ManageOrders.class);
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}