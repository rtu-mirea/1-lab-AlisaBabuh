package com.company;

public class Client extends User
{
    protected String place;

    public Client(){}
    public Client(String name, String login, String password)
    {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public void setPlace(String place)
    {
        this.place=place;
    }
    public String getPlace()
    {
        return place;
    }
}
