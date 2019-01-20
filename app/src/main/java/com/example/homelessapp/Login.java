package com.example.homelessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.homelessapp.Database.SampleDataProvider;
import com.example.homelessapp.Database.User;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = findViewById(R.id.username);
        final EditText etPassword = findViewById(R.id.password);
        final ProgressBar progressBar = findViewById(R.id.loginProgressBar);
        progressBar.setVisibility(View.INVISIBLE);



        /*bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                progressBar.setVisibility(View.VISIBLE);
                Intent intent
                    if (username.equals(##) && password.equals(##)) {
                                intent = new Intent(Login.this, Dashboard.class);
                                intent.putExtra("username", username);
                                Login.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                builder.setMessage("Wrong username or password")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        progressBar.setVisibility(View.INVISIBLE);
                    }
    }*/
}
}
