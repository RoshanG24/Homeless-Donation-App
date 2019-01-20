package com.example.homelessapp.Database;

import java.util.ArrayList;

public class HomelessPerson {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String biography;
    private String lifeGoals;
    private String location;
    private String picture;
    private ArrayList<String> pots;

    public HomelessPerson(int id, String firstName, String lastName, int age, String biography, String lifeGoals ,String location, String picture, ArrayList<String> pots) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.biography = biography;
        this.lifeGoals = lifeGoals;
        this.location = location;
        this.picture = picture;
        this.pots = pots;
    }

    public String getLifeGoals() {
        return lifeGoals;
    }

    public void setLifeGoals(String lifeGoals) {
        this.lifeGoals = lifeGoals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public ArrayList<String> getPots() {
        return pots;
    }

    public void setPots(ArrayList<String> pots) {
        this.pots = pots;
    }
}
