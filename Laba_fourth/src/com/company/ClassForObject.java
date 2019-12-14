package com.company;

import java.util.Scanner;

public class ClassForObject {
    private ClassFrom2Laba str = new ClassFrom2Laba();
    public void consoleInput(){
        System.out.println("Введите данные ");
        str.setText(new Scanner(System.in).nextLine());
    }
    public void dataStream(String text){
        str.setText(text);
    }
    public ClassFrom2Laba getObject(){
        return str;
    }
}
