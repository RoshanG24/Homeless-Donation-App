package com.example.homelessapp;

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

public class Dashboard extends AppCompatActivity {

    PieChartView pieChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        pieChartView = findViewById(R.id.chart);

        addData(pieChartView);




    }

    public void addData(PieChartView pcv) {

        ArrayList amounts = getAmounts();
        List pieData = new ArrayList<>();
        Float a = (float) amounts.get(0);
        Float b = (float) amounts.get(1);
        Float c = (float) amounts.get(2);


        pieData.add(new SliceValue(a, Color.parseColor("#E0E0E0")).setLabel("Food: " + a));
        pieData.add(new SliceValue(b, Color.parseColor("#E0E0E0")).setLabel("Rent: " + b));
        pieData.add(new SliceValue(c, Color.parseColor("#E0E0E0")).setLabel("Clothes: " + c));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pcv.setPieChartData(pieChartData);
    }

    public ArrayList getAmounts() {
        float food = 0;
        float rent = 0;
        float clothes = 0;

        for(Donation donation : SampleDataProvider.donations) {
            if (donation.getPot() == "Food" ) {
                food += donation.getAmount();
            }

            if (donation.getPot() == "Clothes" ) {
                clothes += donation.getAmount();
            }

            if (donation.getPot() == "Rent" ) {
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

