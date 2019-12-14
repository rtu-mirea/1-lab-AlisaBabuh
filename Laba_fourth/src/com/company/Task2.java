package com.company;

import javax.xml.namespace.QName;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Task2 {
    public static void save(String fileName)throws Exception{
        Scanner in = new Scanner(System.in);
        int count, weight, height;
        String surname, name, date, gender, type;

        File file = new File(fileName);
        if(file.exists())
            System.out.println("Файл " + fileName + " уже сущeствует");
        else {
            file.createNewFile();
            System.out.println("Файл " + fileName + " был создан");
        }

        DataOutputStream out = new DataOutputStream((new FileOutputStream(file, true)));
        System.out.println("Введите количество спортсменов:");
        count = in.nextInt();
        in.nextLine();
        for(Integer i = 0; i < count; i++){
            System.out.println("Введите фамилию спортсмена №" + (i + 1));
            surname = in.nextLine();
            System.out.println("Введите имя спортсмена №" + (i + 1));
            name = in.nextLine();
            System.out.println("Введите дату рождения спортсмена №" + (i + 1));
            date = in.nextLine();
            System.out.println("Введите вес спортсмена №" + (i + 1));
            weight = in.nextInt();
            System.out.println("Введите рост спортсмена №" + (i + 1));
            height = in.nextInt();
            in.nextLine();
            System.out.println("Введите пол спортсмена №" + (i + 1));
            gender = in.nextLine();
            System.out.println("Введите вид спорта спортсмена №" + (i + 1));
            type = in.nextLine();
            out.writeUTF(surname);
            out.writeUTF(name);
            out.writeUTF(date);
            out.writeInt(weight);
            out.writeInt(height);
            out.writeUTF(gender);
            out.writeUTF(type);
        }
        out.close();
    }
    public static LinkedList<Sportsman> load(String filename){
        LinkedList<Sportsman> sportsmen = new LinkedList<Sportsman>();
        try{
            DataInputStream in = new DataInputStream(new FileInputStream(filename));
            while (true)
                sportsmen.add(new Sportsman(in.readUTF(), in.readUTF(), in.readUTF(), in.readInt(), in.readInt(),in.readUTF(),in.readUTF()));
        }
        catch (Exception e){}

        return Sportsman.getOneHeight(sportsmen);
    }
    public static LinkedList<Sportsman> randomAccess(LinkedList<Sportsman> sportsmen)throws Exception{
        RandomAccessFile rf = new RandomAccessFile("FileForRandomAccess.txt", "rw");
        int buf = sportsmen.size();
        for(Sportsman sportsman: sportsmen){
            sportsman.increase();
            rf.writeUTF(sportsman.getSurname());
            rf.writeUTF(sportsman.getName());
            rf.writeUTF(sportsman.getDate());
            rf.writeInt(sportsman.getWeight());
            rf.writeInt(sportsman.getHeight());
            rf.writeUTF(sportsman.getGender());
            rf.writeUTF(sportsman.getType());
        }
        sportsmen.clear();
        rf.seek(0);
        for(int i = 0; i < buf; i++){
            sportsmen.add(new Sportsman(rf.readUTF(), rf.readUTF(), rf.readUTF(), rf.readInt(), rf.readInt(), rf.readUTF(), rf.readUTF()));
        }
        return Sportsman.changeSportsmens(sportsmen);
    }
}
