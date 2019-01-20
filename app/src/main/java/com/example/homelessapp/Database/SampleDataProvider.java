package com.example.homelessapp.Database;

import android.support.v4.content.res.TypedArrayUtils;

import java.util.ArrayList;

public class SampleDataProvider {
    public static ArrayList<HomelessPerson> homelessPeople;
    public static ArrayList<String> pots;
    public static ArrayList<User> users;

    static {

        pots = new ArrayList<>();
        pots.add("Food");
        pots.add("Rent");
        pots.add("Clothing");

        homelessPeople = new ArrayList<>();
        homelessPeople.add(new HomelessPerson( 1234,"Frank",  "Samwise", 23, "Hello, I am homeless and need your help please pllease", "Reading, Uk", null, pots));
        homelessPeople.add(new HomelessPerson(4321,"Beth",  "Smith", 40, "I am temporarily homeless please", "London, UK",  null, pots));

        users = new ArrayList<>();
        users.add(new User("BobALob", "password", "bob@gmail.com"));
    }
}
