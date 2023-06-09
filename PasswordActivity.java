package com.example.wedeliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {

    private EditText username;
    private Button btnresetpass;
    com.example.wedeliver.DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        username = (EditText) findViewById(R.id.username);
        btnresetpass = (Button) findViewById(R.id.btnresetpass);
        DB = new com.example.wedeliver.DBHelper(this);

        btnresetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();

                Boolean checkuser = DB.checkUsername(user);
                if(checkuser == true)
                {
                    Intent intent = new Intent(PasswordActivity.this, ResetActivity.class);
                    intent.putExtra("username", user);
                    startActivity(intent);
                }
                else
                    Toast.makeText(PasswordActivity.this, "User does not exist!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}