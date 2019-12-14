//Задание: применение класса String(First), StringBuffer/StringBuilder(Second), регулярные выражения(Third)
package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int comm = -1;
        Scanner in = new Scanner(System.in);
        outputMenu();
        First first = new First();
        Second second = new Second();
        Third third = new Third();
        while(comm != 0){
            System.out.print("Введите желаемую команду: ");
            comm = in.nextInt();
            switch (comm){
                case 1:
                    outputMenu();
                    break;
                case 2:{
                    System.out.print("Введите набор из нескольких ключевых слов языка Си: ");
                    Scanner in2 = new Scanner(System.in);
                    String line = in2.nextLine();
                    HashSet<String> keys = new HashSet<String>();
                    for(String key: line.split(" "))
                        keys.add(key);
                    first.setKeys(keys);
                    second.setKeys(keys);
                }
                break;
                case 3: {
                    Scanner in2 = new Scanner(System.in);
                    System.out.print("Введите код программы на языке Си: ");
                    first.setText(in2.nextLine());
                }
                break;
                case 4:
                    first.showEntrys();
                    break;
                case 5:
                    first.toUpper();
                    break;
                case 6:
                    first.countEntrys();
                    break;
                case 7:
                    first.getIdentificators();
                    break;
                case 8: {
                    Scanner in2 = new Scanner(System.in);
                    System.out.print("Введите текст: ");
                    second.setText(new StringBuilder(in2.nextLine()));
                }
                break;
                case 9:
                    second.identificator();
                    break;
                case 10:
                    second.delIndent();
                    break;
                case 11:
                    second.insertNew();
                    break;
                case 12:{
                    Scanner in2 = new Scanner(System.in);
                    System.out.print("Введите текст: ");
                    third.setText(in2.nextLine());
                    third.checkNum();
                }
                break;
                case 13: {
                    Scanner in2 = new Scanner(System.in);
                    System.out.print("Введите текст: ");
                    third.setText(in2.nextLine());
                    third.delNum();
                }
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

    public static void outputMenu(){
        System.out.println("1) Вывод меню повторно.");
        System.out.println("2) Ввод набора из ключевых слов.");
        System.out.println("3) Ввод кода программы на языке Си.");
        System.out.println("1 - 4) Сформировать строку из ключевых слов языка, которые используются в тексте.");
        System.out.println("1 - 5) Первые строчные символы в словах сформированного массива заменить прописными.");
        System.out.println("1 - 6) Сформировать массив, который хранит количество вхождений каждого ключевого слова в код программы.");
        System.out.println("1 - 7) Сформировать строку из пользовательских идентификаторов.");
        System.out.println("8) Ввод кода программы на языке Си для второго задания.");
        System.out.println("2 - 9) Сформировать строку из пользовательских идентификаторов левой части оператора присваивания.");
        System.out.println("2 - 10) Преобразовать строку: оставить только ключевые слова языка, которые используются в тексте.");
        System.out.println("2 - 11) Вставить новое ключевое слово, которого нет в строке, перед первым словом.");
        System.out.println("3 - 12) Определить, является ли переданная строка корректным\n" +
                "временем вида '12:59', '23:41', '00:12', '00:00', '09:15'.");
        System.out.println("3 - 13) Удаление из текста всех значений времени из промежутка 00:00 до 02:00.");
        System.out.println("0) Выход из программы.");
    }
}
