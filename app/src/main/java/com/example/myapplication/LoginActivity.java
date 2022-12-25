package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText etuser, etpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etuser = findViewById(R.id.etuser);
        etpass = findViewById(R.id.etpass);
        // final String email=etemail.getText().toString().trim();
        //final String pass=etpass.getText().toString().trim();
        Button btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logIn();
            }
        });
    }

    private void logIn() {
        String user = etuser.getText().toString().trim();
        String pass = etpass.getText().toString();
        if (TextUtils.isEmpty(user)) {
            etuser.setError("Please Enter Username");
            etuser.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            etpass.setError("Please Enter Password");
            etpass.requestFocus();
            return;
        }

        else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}