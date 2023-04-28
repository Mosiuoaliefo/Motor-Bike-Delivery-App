package com.example.wedeliver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button btnsignin;
    private TextView txtresetpass;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnsignin = (Button) findViewById(R.id.btnresetpass);
        txtresetpass = (TextView) findViewById(R.id.txtresetpass);
        DB = new DBHelper(this);



        txtresetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, PasswordActivity.class);
                startActivity(intent);
            }
        });

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInAs(view);
            }
        });
    }

    public void signInAs(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("User Login")
                .setMessage("Login As ...")
                .setPositiveButton("Customer", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        String user = username.getText().toString();
                        String pass = password.getText().toString();

                        if(user.equals(""))
                        {
                            Toast.makeText(LoginActivity.this, "Enter Username", Toast.LENGTH_SHORT).show();
                        }
                        else if(pass.equals(""))
                        {
                            Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                            if(checkuserpass == true)
                            {
                                Toast.makeText(LoginActivity.this, "Login granted!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, userdashboard.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(LoginActivity.this, "Wrong Credentials. Try Again...", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Staff", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String user = username.getText().toString();
                        String pass = password.getText().toString();

                        if(user.equals(""))
                        {
                            Toast.makeText(LoginActivity.this, "Enter Username", Toast.LENGTH_SHORT).show();
                        }
                        else if(pass.equals(""))
                        {
                            Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            if(user.equals("mosiuoa") && pass.equals("liefo"))
                            {
                                Toast.makeText(LoginActivity.this, "Login granted!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, StaffDashboard.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(LoginActivity.this, "Wrong Credentials. Try Again...", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}