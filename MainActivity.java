package com.example.wedeliver;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText Name, Marks;
    Button Add;
    Button View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);

     /*   Name = (EditText)findViewById(R.id.txtName);
        Marks = (EditText)findViewById(R.id.txtMarks);
        Add = (Button)findViewById(R.id.button);
        View = (Button)findViewById(R.id.button2);*/
    }

 /*   public void addData(View v){
        boolean status = myDB.insertData(Name.getText().toString(), Marks.getText().toString());
        if(status)
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
    }

    public void viewAll(View v){
        Cursor result = myDB.getData();
        if(result.getCount() == 0){
            showMessage("Error", "Nothing Found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(result.moveToNext()){
            buffer.append("ID : " + result.getString(0) + "\n")
                    .append("Name : " + result.getString(1) + "\n")
                    .append("Marks : " + result.getString(2) + "\n\n");
        }
        showMessage("Data", buffer.toString());

    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .show();
    }*/
}
