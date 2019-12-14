package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Sportsman {
    private String surname;
    private String name;
    private String date;
    private int weight;
    private int height;
    private String gender;
    private String type;

    public String getSurname(){return surname;}
    public String getName(){return name;}
    public String getDate(){return date;}
    public int getWeight(){return weight;}
    public int getHeight(){return height;}
    public String getGender(){return gender; }
    public String getType(){return type;}

    public Sportsman(){
        surname = "";
        name = "";
        date = "";
        weight = 0;
        height = 0;
        gender = "";
        type = "";
    }
    public Sportsman(String surname, String name, String date, int weight, int height,String gender, String type){
        this.surname = surname;
        this.name = name;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.type = type;
    }
    public String getTypeOfSur(String surname){
        if (this.surname.compareTo(surname) == 0)
            return this.type;
        else return "";
    }
    public int getWeightOfSur(String surname){
        if (this.surname.compareTo(surname) == 0)
            return this.weight;
        else return 0;
    }
    public int getHeightOfSur(String surname){
        if (this.surname.compareTo(surname) == 0)
            return this.height;
        else return 0;
    }
    public boolean compareOnType(Sportsman sportsman){
        return this.type.compareTo(sportsman.type) == 0;
    }
    public static LinkedList<Sportsman> getOneHeight(LinkedList<Sportsman> sportsmen){
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> heightArr = new LinkedList<Integer>();
        boolean isNew = true;
        LinkedList<Sportsman> result = new LinkedList<Sportsman>();
        for(Sportsman sportsman: sportsmen){
            for(int height: heightArr){
                if (height == sportsman.height)
                    isNew = false;
            }
            if(isNew) heightArr.add(sportsman.height);
            isNew = true;
        }
        System.out.println("Список ростов, всех спортсменов:");
        for(int height: heightArr)
            System.out.println(height);
        System.out.println("Выберите нужный вам рост");
        int height = in.nextInt();
        for(Sportsman sportsman: sportsmen){
            if (sportsman.height == height)
                result.add(sportsman);
        }
        return result;
    }
    public static LinkedList<Sportsman> changeSportsmens(LinkedList<Sportsman> sportsmen){
        int first = 0, last = 0;
        boolean flag = false;
        for (int i = 0; i < sportsmen.size() - 1; i++){
            for (int n = i + 1; n < sportsmen.size(); n++){
                if (sportsmen.get(i).compareOnType(sportsmen.get(n))){
                    last = n;
                    if (!sportsmen.get(i).compareOnType(sportsmen.get(first)))
                        flag = true;
                }
                if (flag) {
                    first = i;
                    flag = false;
                }
            }
        }
        Sportsman buf = sportsmen.get(last);
        sportsmen.set(last, sportsmen.get(first));
        sportsmen.set(first, buf);
        return sportsmen;
    }
    public void increase(){
        surname = grow(surname);
        name = grow(name);
        date = grow(date);
        gender = grow(gender);
        type = grow(type);
    }
    private static String grow(String str){
        for(int i = str.length(); i <= 20; i++)
            str+=" ";
        return str;
    }
}
