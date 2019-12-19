package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;

import static java.lang.Integer.parseInt;

public class PizzaSystem
{
    private List<User> users = new ArrayList<>();
    private Map map = new Map();
    private User currentUser;
    private String currentLocation;
    private Scanner in = new Scanner(System.in);
    private boolean end = false;

    public static void main(String[] args)
    {
        PizzaSystem p = new PizzaSystem();
        p.users.add(new Admin("Admin", "admin", "1"));
        p.currentUser = p.users.get(0);
        while(!p.end)
        {
            p.mainMenu();
            if (p.currentUser.getClass() == Client.class)
            {
                Client client = (Client)p.currentUser;
                p.clientMenu(client);
            }
            else if (p.currentUser.getClass() == Admin.class)
                p.adminMenu();
        }
    }
    private void mainMenu(){
        boolean exit=false;
        while (!exit) {
            System.out.println("Войти(1), Зарегестрироваться(2):");
            int choice = in.nextInt();
            while (choice==1) {
                System.out.println("Если хотите выйти введите exit:");
                String goBack = in.nextLine();
                if(goBack.equals("exit")){
                    break;
                }
                else {
                    System.out.println("Введите логин: ");
                    String curLogin = in.nextLine();
                    System.out.println("Введите пароль: ");
                    String curPassword = in.nextLine();
                    User CurUser = findUser(curLogin, curPassword);
                    if (CurUser != null) {
                        currentUser = CurUser;
                        choice = 0;//exit
                        exit=true;
                    } else {
                        System.out.println("Попробуйте еще.");
                    }
                }
            }
            if (choice==2){
                System.out.println("Введите имя: ");
                String curName = in.nextLine();

                System.out.println("Введите логин: ");
                String curLogin = in.nextLine();

                System.out.println("Введите пароль: ");
                String curPassword = in.nextLine();

                System.out.println("Введите место: ");
                String curPlace = in.nextLine();

                addUser(curName,curLogin,curPassword,curPlace);

            }

        }

    }
    private void clientMenu(Client client){
        boolean exit = false;
        while (!exit) {
            System.out.println("Введите команду (add, exit)");
            String cm = in.nextLine();
            switch (cm) {
                case "add":
                    System.out.println("Введите место: ");
                    String place1 = in.nextLine();
                    System.out.println("Введите время : ");
                    String time= in.nextLine();
                    map.addPath(place1,client.getPlace(), parseInt(time));
                    break;
                case "exit":
                    exit=true;
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
        }
    }

    private void adminMenu(){
        boolean exit = false;
        while (!exit) {
            System.out.println("Введите команду (way, exit)");
            String cm = in.nextLine();
            switch (cm) {
                case "way":
                    map.fill();
                    System.out.println("точка А : ");
                    String A= in.nextLine();
                    System.out.println("точка В: ");
                    String B= in.nextLine();
                    List<String> results = map.get_shortest_way(A,B);
                    end = true;
                    for(int i=0;i<results.size();i++)
                    {
                        System.out.println((i+1)+". " + results.get(i));
                    }
                case "exit":
                    exit=true;
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
        }
    }

    private void addUser(String name, String login, String password,String curPlace)
    {
        User user = findUser(login,password);
        if(user==null){Client client = new Client(name,login,password); client.setPlace(curPlace); users.add(client); System.out.println("Новый пользователь создан"); }
        else {System.out.println("Уже зарегестрирован");}
    }

    private User findUser(String login, String password){
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).enter(login,password)){return users.get(i);}
        }
        System.out.println("Не могу найти этого пользователя");
        return null;
    }
}

