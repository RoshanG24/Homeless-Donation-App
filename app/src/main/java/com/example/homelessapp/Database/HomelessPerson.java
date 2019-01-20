package com.example.homelessapp.Database;

import java.util.ArrayList;

public class HomelessPerson {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String biography;
    private String location;
    private String picture;
    private ArrayList<String> pots;

    public HomelessPerson(int id, String firstName, String lastName, int age, String biography, String location, String picture, ArrayList<String> pots) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.biography = biography;
        this.location = location;
        this.picture = picture;
        this.pots = pots;
    }
}
