package com.example.homelessapp.Database;

import android.support.v4.content.res.TypedArrayUtils;

import java.util.ArrayList;

public class SampleDataProvider {
    public static ArrayList<HomelessPerson> homelessPeople;
    public static ArrayList<String> pots;

    static {

        pots = new ArrayList<>();
        pots.add("Food");
        pots.add("Rent");
        pots.add("Clothing");

        homelessPeople = new ArrayList<>();
        homelessPeople.add(new HomelessPerson("Frank Samwise", 23, "Hello, I am homeless and need your help please pllease", pots));
        homelessPeople.add(new HomelessPerson("Frank Samwise", 23, "Hello, I am homeless and need your help please pllease", pots));

    }
}
