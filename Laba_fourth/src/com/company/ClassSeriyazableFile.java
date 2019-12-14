package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassSeriyazableFile {
    private String fileName;
    ArrayList<ClassFrom2Laba> objects;

    public ClassSeriyazableFile(String str){
        fileName = str;
        objects = new ArrayList<ClassFrom2Laba>();
    }
    public void writeOneObject(ClassFrom2Laba obj)throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(obj);
        out.close();
    }
    public ClassFrom2Laba readObeObject()throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        ClassFrom2Laba x = (ClassFrom2Laba) in.readObject();
        in.close();
        return x;
    }
    public void majeCollection() throws Exception{
        Scanner in = new Scanner(System.in);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName, true));
        ClassFrom2Laba o;
        System.out.println("Введите количество объектов: ");
        int count = in.nextInt();
        in.nextLine();
        for (int i = 0; i < count; i++){
            System.out.println("Введите строку для объекта №" + (i + 1));
            o = new ClassFrom2Laba(in.nextLine());
            objects.add(o);
            out.writeObject(o);
        }
        out.close();
    }
    public void readCollection() throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        ArrayList<ClassFrom2Laba> arr = new ArrayList<ClassFrom2Laba>();
        try{
            while(true){
                arr.add((ClassFrom2Laba)in.readObject());
            }
        }
        catch (Exception e){}
        objects = arr;
    }
    public ArrayList<ClassFrom2Laba> getCollection(){return objects;}
}