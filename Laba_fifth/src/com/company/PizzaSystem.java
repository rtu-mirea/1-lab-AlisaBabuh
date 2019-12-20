package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;
import javax.swing.*;

import static java.lang.Integer.parseInt;

public class PizzaSystem extends JFrame
{
    public static List<User> users;
    public static Map map = new Map();
    public static User currentUser;
    public static String currentLocation;

    public static User addUser(String name, String login, String password){
        return new Client(name, login, password);
    }

    public static void main(String[] args)
    {
        users = new ArrayList<User>();
        Admin admin;
        admin = new Admin("admin", "admin", "admin");
        users.add(admin);
        new GUI().Menu();
    }

}
