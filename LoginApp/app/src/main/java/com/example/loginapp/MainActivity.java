package com.example.loginapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }

    public void login(View view) {



        String loginEmail = String.valueOf(email.getText());
        String loginPassword =  String.valueOf(password.getText());

        if (loginEmail.equals("admin@admin.com") && loginPassword.equals("admin123")) {
            Intent i = new Intent(getApplicationContext(),Home.class);
            startActivity(i);
        } else {
            password.setError("invalid login");
            Toast.makeText(this, "invalid email or password", Toast.LENGTH_SHORT).show();
        }



    }
}

