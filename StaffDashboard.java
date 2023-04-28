package com.example.wedeliver;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StaffDashboard extends AppCompatActivity {
    DatabaseHelper myDb;
    Button btnviewAll;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_dashboard);
        myDb = new DatabaseHelper(this);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        viewAll();
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("ID :"+ res.getString(0)+"\n");
                            buffer.append("User Name :"+ res.getString(1)+"\n");
                            buffer.append("Email :"+ res.getString(2)+"\n\n");
                           /* buffer.append("Marks :"+ res.getString(3)+"\n\n");*/
                        }

                        // Show all data
                        showMessage("\t CUSTOMER DATA",buffer.toString());
                    }
                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    public void gototracks(View view){
        Intent intent = new Intent(StaffDashboard.this, TrackedOrders.class);
        Toast.makeText(this, "tracked", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void gotomanagement(View view){
        Intent intent = new Intent(StaffDashboard.this, ManageOrders.class);
        Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void gotomanage(View view){
        Intent intent = new Intent(StaffDashboard.this, DeliveryServices.class);
        Toast.makeText(this, "Managed", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}