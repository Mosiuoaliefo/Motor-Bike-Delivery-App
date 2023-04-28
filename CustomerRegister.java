package com.example.wedeliver;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerRegister extends AppCompatActivity {

    // Variable Declaration
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText repassword;
    private Button btnsignup;
    private Button btnreset;
    private TextView txttologin;
    com.example.wedeliver.DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_register);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        btnsignup = (Button) findViewById(R.id.btnsignup);
        btnreset = (Button) findViewById(R.id.btnreset);
        DB = new com.example.wedeliver.DBHelper(this);

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                username.setText("");
                email.setText("");
                password.setText("");
                repassword.setText("");
            }
        });


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String em = email.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals(""))
                {
                    Toast.makeText(CustomerRegister.this, "Enter Username", Toast.LENGTH_SHORT).show();
                }
                else if(em.equals(""))
                {
                    Toast.makeText(CustomerRegister.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }
                else if(pass.equals(""))
                {
                    Toast.makeText(CustomerRegister.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else if(repass.equals(""))
                {
                    Toast.makeText(CustomerRegister.this, "Confirm Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pass.equals(repass))
                    {
                        Boolean checkuser = DB.checkUsername(user);
                        if(checkuser == false)
                        {
                            Boolean insert = DB.insertData(user,em,pass);
                            if(insert == true)
                            {
                                Toast.makeText(CustomerRegister.this, "Register Granted!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(CustomerRegister.this, com.example.wedeliver.LoginActivity.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(CustomerRegister.this, "Registration Unsuccesssful!", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(CustomerRegister.this, "User Exists!", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(CustomerRegister.this, "passwords not the same!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void gotobikes(View view){
        Intent intent = new Intent(CustomerRegister.this, LoginActivity.class);
        Toast.makeText(this, "Loading, Please Wait", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}