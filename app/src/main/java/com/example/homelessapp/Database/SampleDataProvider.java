package com.example.homelessapp.Database;

import android.support.v4.content.res.TypedArrayUtils;

import java.util.ArrayList;

public class SampleDataProvider {
    public static ArrayList<HomelessPerson> homelessPeople;
    public static ArrayList<String> pots;
    public static ArrayList<User> users;
    public static ArrayList<Donation> donations;

    static {

        pots = new ArrayList<>();
        pots.add("Food");
        pots.add("Rent");
        pots.add("Clothing");

        homelessPeople = new ArrayList<>();

        homelessPeople.add(new HomelessPerson( 1234,"Frank",  "Samwise", 23, "I'm an ex music student who lost my job because of health issues, I'm living between shelters and using food banks. I'm aiming to save up for a new guitar so I can busk to start earning some money for myself.", "To be a professional musician" , "Reading, UK", "p1234", pots));
        homelessPeople.add(new HomelessPerson(4321,"Beth",  "Smith", 40, "I am temporarily homeless after losing my job. Looking for any work opportunities and opportunities to better myself.", "Own a business","London, UK",  "p4321", pots));

        donations = new ArrayList<>();
        donations.add(new Donation(10, "Love you", "bob", "1234", "Food"));
        donations.add(new Donation(20, "Love you", "bob", "1234", "Rent"));
        donations.add(new Donation(250, "Love you", "bob", "1234", "Food"));
        donations.add(new Donation(350, "Love you", "bob", "1234", "Rent"));
        donations.add(new Donation(700, "Love you", "bob", "1234", "Clothing"));

        users = new ArrayList<>();
        users.add(new User("bob", "password", "bob@gmail.com"));
    }
}
