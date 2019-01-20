package com.example.homelessapp.Database;

public class Donation {
    private float amount;
    private String message;
    private String user;
    private String homie;
    private String pot;

    public Donation(float amount, String message, String user, String homie, String pot)
    {
        this.amount = amount;
        this.message = message;
        this.user = user;
        this.homie = homie;
        this.pot = pot;
    }

    public float getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return user;
    }

    public String getHomie() {
        return homie;
    }

    public String getPot() {
        return pot;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setHomie(String homie) {
        this.homie = homie;
    }

    public void setPot(String pot) {
        this.pot = pot;
    }
}
