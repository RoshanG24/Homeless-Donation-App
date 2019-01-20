package com.example.homelessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.homelessapp.Database.SampleDataProvider;
import com.example.homelessapp.Database.User;

import java.util.ArrayList;

import static com.example.homelessapp.Database.SampleDataProvider.users;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = findViewById(R.id.username);
        final EditText etPassword = findViewById(R.id.password);
        final ProgressBar progressBar = findViewById(R.id.loginProgressBar);
        final Button login_button =  findViewById(R.id.login_button);

        progressBar.setVisibility(View.INVISIBLE);



        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                progressBar.setVisibility(View.VISIBLE);
                Intent intent;

                for (int i = 0; i < users.size(); i++) {
                    User user = users.get(i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
                        intent = new Intent(Login.this, Dashboard.class);
                        intent.putExtra("username", username);
                        Login.this.startActivity(intent);
                        progressBar.setVisibility(View.INVISIBLE);
                        break;
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                        builder.setMessage("Wrong username or password")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
            });
                }



}
