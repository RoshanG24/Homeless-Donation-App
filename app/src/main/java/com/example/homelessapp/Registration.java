package com.example.homelessapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.homelessapp.Database.User;

import static com.example.homelessapp.Database.SampleDataProvider.users;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final Button register_button =  findViewById(R.id.button);


        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Registration.this, Dashboard.class);
                intent.putExtra("username", "bob");
                Registration.this.startActivity(intent);
            }
        });
    }
}
