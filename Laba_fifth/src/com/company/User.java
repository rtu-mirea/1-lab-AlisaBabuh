package com.company;

public class User
{
    protected String name;
    protected String login;
    protected String password;

    public User(){}

    public User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }

    boolean enter(String login, String password) {
        if (this.login.equals(login) && this.password.equals(password))
        {
            return true;
        }
        else return false;
    }

    String getName()
    {
        return name;
    }

    public void setName(String name) { this.name = name;}

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
