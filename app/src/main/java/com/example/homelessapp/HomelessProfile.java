package com.example.homelessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homelessapp.Database.HomelessPerson;
import com.example.homelessapp.Database.SampleDataProvider;

import java.util.ArrayList;

public class HomelessProfile extends AppCompatActivity {

    private HomelessPerson homelessPerson;
    private int id;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeless_profile);

        Intent intent = getIntent();
        userName = intent.getStringExtra("USERNAME");
        int id = intent.getIntExtra("HOMELESS-ID", -1);
        if(id == -1){
            id = 4321; //todo fix this please
        }
        for (HomelessPerson person: SampleDataProvider.homelessPeople) {
            if(id == person.getId()){
                homelessPerson = person;
                break;
            }
        }

        ImageView profileImage = findViewById(R.id.profile_image);
        int imageId = getResources().getIdentifier("drawable/" + homelessPerson.getPicture(), null, getPackageName());
        profileImage.setImageResource(imageId);

        TextView tv = findViewById(R.id.about_content);
        tv.setText(homelessPerson.getBiography());
        tv.setMovementMethod(new ScrollingMovementMethod());

        TextView tv2 = findViewById(R.id.life_goals_content);
        tv2.setText(homelessPerson.getLifeGoals());
        tv2.setMovementMethod(new ScrollingMovementMethod());

        TextView firstName = findViewById(R.id.first_name);
        firstName.setText(homelessPerson.getFirstName());

        TextView lastName = findViewById(R.id.last_name);
        lastName.setText(homelessPerson.getLastName());

        TextView location = findViewById(R.id.location);
        location.setText(homelessPerson.getLocation());


        Button donateButton = findViewById(R.id.donate);

        final int idToSend = id;
        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomelessProfile.this, DonationPots.class);
                intent.putExtra("USERNAME", "bob");  //todo fix this
                intent.putExtra("HOMELESS-ID", idToSend);
                startActivity(intent);
            }
        });

    }
}
