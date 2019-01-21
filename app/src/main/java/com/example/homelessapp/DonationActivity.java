package com.example.homelessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.homelessapp.Database.HomelessPerson;
import com.example.homelessapp.Database.SampleDataProvider;
import com.example.homelessapp.Database.Donation;


public class DonationActivity extends AppCompatActivity {

    private HomelessPerson homelessPerson;
    private String username;
    private String pot;
//    final Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME");
        pot = intent.getStringExtra("pot");
        int id = intent.getIntExtra("homie", -1);
        if(id == -1){
            id = 1234; //todo fix this please
        }

        for (HomelessPerson person: SampleDataProvider.homelessPeople) {
            if(id == person.getId()){
                homelessPerson = person;
                break;
            }
        }

        TextView homie = findViewById(R.id.donateeName);
        String fullName = homelessPerson.getFirstName() + " " + homelessPerson.getLastName();
        homie.setText(fullName);

        TextView potName = findViewById(R.id.potName);
        potName.setText(pot);

    }

    public void donate(View view) {
        EditText message = findViewById(R.id.message);
        message.getText();
        System.out.println(message.getText());

        EditText amount = findViewById(R.id.donationAmount);
        amount.getText();

        System.out.println(amount.getText());


        float value = Float.valueOf(amount.getText().toString());

        SampleDataProvider.donations.add(new Donation(value, message.toString(), "bob", "1234", pot));
        System.out.println(getIntent().getStringExtra("pot"));
        Intent intent = new Intent(DonationActivity.this, Dashboard.class);
        intent.putExtra("username", username);

        DonationActivity.this.startActivity(intent);
    }
}
