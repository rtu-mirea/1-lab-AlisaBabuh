//Задание: применение класса String(First), StringBuffer/StringBuilder(Second), регулярные выражения(Third)
package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int comm = -1;
        Scanner in = new Scanner(System.in);

        First first = new First();
        Second second = new Second();
        Third third = new Third();
        while(comm != 0){
            System.out.print("1 - первое задание\n2 - второе задание\n3 - третье задание\nВведите желаемую команду: ");
            comm = in.nextInt();
            switch (comm){
                case 1:
                    System.out.print("Введите набор из нескольких ключевых слов языка Си: ");
                    Scanner in2 = new Scanner(System.in);
                    String line = in2.nextLine();
                    HashSet<String> keys = new HashSet<String>();
                    for(String key: line.split(" "))
                        keys.add(key);
                    first.setKeys(keys);
                    second.setKeys(keys);

                    System.out.print("Введите код программы на языке Си: ");
                    first.setText(in2.nextLine());

                    first.showEntrys();
                    first.toUpper();
                    first.countEntrys();
                    first.getIdentificators();

                    break;

                case 2:
                    Scanner in1 = new Scanner(System.in);
                    System.out.print("Введите текст: ");
                    second.setText(new StringBuilder(in1.nextLine()));

                    second.identificator();
                    second.delIndent();
                    second.insertNew();

                break;

                case 3:
                    Scanner in3 = new Scanner(System.in);
                    System.out.print("Введите текст: ");
                    third.setText(in3.nextLine());

                    third.checkNum();
                    third.delNum();

                break;

                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Введена неверная команда, пожалуйста, повторите ввод!");
                    break;
            }
        }
    }


}
