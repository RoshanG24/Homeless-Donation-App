package com.example.homelessapp.Database;

import java.util.ArrayList;

public class HomelessPerson {

    private String name;
    private int age;
    private String biography;
    private ArrayList<String> pots;

    public HomelessPerson(String name, int age, String biography, ArrayList<String> pots) {
        this.name = name;
        this.age = age;
        this.biography = biography;
        this.pots = pots;
    }
}
