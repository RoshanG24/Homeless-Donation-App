package com.example.homelessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DonationPots extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_pots);

        Intent intent = getIntent();
        int id = intent.getIntExtra("HOMELESS-ID", -1);
        if(id == -1){
            id = 4321; //todo fix this please
        }
        final int idToSend = id;
        Button foodButton = findViewById(R.id.foodButton);


        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonationPots.this, DonationActivity.class);
                intent.putExtra("pot", "Food");
                intent.putExtra("homie", idToSend);
                startActivity(intent);
            }
        });


        Button rentButton = findViewById(R.id.rentButton);

        rentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonationPots.this, DonationActivity.class);
                intent.putExtra("pot", "Rent");
                intent.putExtra("homie", idToSend);
                startActivity(intent);
            }
        });

        Button clothingButton = findViewById(R.id.clothingButton);

        rentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonationPots.this, DonationActivity.class);
                intent.putExtra("pot", "Clothing");
                intent.putExtra("homie", idToSend);
                startActivity(intent);
            }
        });
    }
}
