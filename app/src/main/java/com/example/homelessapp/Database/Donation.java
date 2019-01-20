package com.example.homelessapp.Database;

public class Donation {
    private int amount;
    private String message;
    private User user;
    private HomelessPerson homie;
    private String pot;

    public Donation(int amount, String message, User user, HomelessPerson homie, String pot)
    {
        this.amount = amount;
        this.message = message;
        this.user = user;
        this.homie = homie;
        this.pot = pot;
    }



}
