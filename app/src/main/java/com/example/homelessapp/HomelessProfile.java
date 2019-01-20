package com.example.homelessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.homelessapp.Database.HomelessPerson;
import com.example.homelessapp.Database.SampleDataProvider;

import java.util.ArrayList;

public class HomelessProfile extends AppCompatActivity {

    private HomelessPerson homelessPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeless_profile);

        Intent intent = getIntent();
        int id = intent.getIntExtra("HOMELESS-ID", -1);
        if(id == -1){
            id = 1234; //todo fix this please
        }
        for (HomelessPerson person: SampleDataProvider.homelessPeople) {
            if(id == person.getId()){
                homelessPerson = person;
                break;
            }
        }
        TextView tv = findViewById(R.id.about_content);
        tv.setText(homelessPerson.getBiography());
        tv.setMovementMethod(new ScrollingMovementMethod());

        TextView tv2 = findViewById(R.id.life_goals_content);
        tv2.setText(homelessPerson.getLifeGoals());
        tv2.setMovementMethod(new ScrollingMovementMethod());
    }
}
