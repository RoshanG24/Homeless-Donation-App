package com.example.homelessapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.homelessapp.Database.SampleDataProvider;
import com.example.homelessapp.Database.Donation;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    PieChartView pieChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intent = getIntent();

        String user = intent.getStringExtra("username");
        TextView username = findViewById(R.id.textView);

        username.setText("Hey, " + user);
        pieChartView = findViewById(R.id.chart);

        addData(pieChartView);

    }

    public void addData(PieChartView pcv) {

        ArrayList amounts = getAmounts();
        List<SliceValue> pieData = new ArrayList<SliceValue>();
        Float a = (float) amounts.get(0);
        Float b = (float) amounts.get(1);
        Float c = (float) amounts.get(2);

        TextView food_amount = findViewById(R.id.food_amount);
        TextView rent_amount = findViewById(R.id.rent_amount);
        TextView clothing_amount = findViewById(R.id.clothing_amount);
        TextView total_amount = findViewById(R.id.total_spend);

        Float total = a + b + c;

        food_amount.setText("£" + a);
        rent_amount.setText("£" + b);
        clothing_amount.setText("£" + c);
        total_amount.setText("£" + total);



        pieData.add(new SliceValue(a, Color.parseColor("#FFA500")).setLabel("Food: " + a));
        pieData.add(new SliceValue(b, Color.parseColor("#FFE303")).setLabel("Rent: " + b));
        pieData.add(new SliceValue(c, Color.parseColor("#FFFF7E")).setLabel("Clothing: " + c));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(20);
        pcv.setPieChartData(pieChartData);

    }

    public ArrayList getAmounts() {
        float food = 0;
        float rent = 0;
        float clothes = 0;

        for(Donation donation : SampleDataProvider.donations) {
            if (donation.getPot().equals("Food")) {
                food += donation.getAmount();
            }

            if (donation.getPot().equals("Clothing") ) {
                clothes += donation.getAmount();
            }

            if (donation.getPot().equals("Rent")) {
                rent += donation.getAmount();
            }

        }

        ArrayList amounts = new ArrayList<>();
        amounts.add(food);
        amounts.add(rent);
        amounts.add(clothes);

        return amounts;
    }

}

