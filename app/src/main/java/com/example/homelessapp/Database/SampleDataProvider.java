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
//        homelessPeople.add(new HomelessPerson( 1234,"Frank",  "Samwise", 23, "Hello, I am homeless and need your help please pllease ello, I am homeless and need your help plea ello, I am homeless and need your help plea ello, I am homeless and need your help plea ello, I am homeless and need your help plea ello, I am homeless and need your help plea ello, I am homeless and need your help pleaello, I am homeless and need your help plea  ello, I am homeless and need your help plea ello, I am homeless and need your help pleaello, I am homeless and need your help plea", "Fly a kite" , "Reading, Uk", "1234.jpeg", pots));
//        homelessPeople.add(new HomelessPerson(4321,"Beth",  "Smith", 40, "I am temporarily homeless please", "Get a job","London, UK",  "4321.jpeg", pots));

        homelessPeople.add(new HomelessPerson( 1234,"Frank",  "Samwise", 23, "Hello, I am homeless and need your help please pllease ello, I am homeless and need your help plea ello, I am homeless and need your help plea ello, I am homeless and need your help plea ello, I am homeless and need your help plea ello, I am homeless and need your help plea ello, I am homeless and need your help pleaello, I am homeless and need your help plea  ello, I am homeless and need your help plea ello, I am homeless and need your help pleaello, I am homeless and need your help plea", "Fly a kite" , "Reading, Uk", "p1234", pots));
        homelessPeople.add(new HomelessPerson(4321,"Beth",  "Smith", 40, "I am temporarily homeless please", "Get a job","London, UK",  "p4321", pots));

        donations = new ArrayList<>();
        donations.add(new Donation(10, "Love you", "bob", "1234", "Food"));
        donations.add(new Donation(20, "Love you", "bob", "1234", "Rent"));
        donations.add(new Donation(50, "Love you", "bob", "1234", "Food"));
        donations.add(new Donation(350, "Love you", "bob", "1234", "Rent"));
        donations.add(new Donation(700, "Love you", "bob", "1234", "Clothes"));

        users = new ArrayList<>();
        users.add(new User("bob", "password", "bob@gmail.com"));
    }
}
