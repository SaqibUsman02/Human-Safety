package com.example.humansafety.model;

public class Motorway_model {
   String Number;
   String User;

    @Override
    public String toString() {
        return "Motorway_model{" +
                "Number='" + Number + '\'' +
                ", User='" + User + '\'' +
                '}';
    }

    public Motorway_model() {
    }

    public Motorway_model(String number, String user) {
        Number = number;
        User = user;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }
}

