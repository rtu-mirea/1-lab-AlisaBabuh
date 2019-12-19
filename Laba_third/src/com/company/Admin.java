package com.company;

public class Admin extends User {
    public Admin(){}

    public Admin(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }
}