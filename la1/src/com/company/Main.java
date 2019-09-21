package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        TestArray();
    }

    public static void TestArray() {
        int n;
        int num = 0;
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Введите размерность массива: ");
            n = in.nextInt();
            Array array = new Array(n);

            while (num != 2 && num != 1) {
                System.out.println("Каким образом вы желаете заполнить массив?");
                System.out.println("1. Рандомными числами.");
                System.out.println("2. Самостоятельно с клавиатуры.");
                System.out.print("Выбранное действие: ");
                num = in.nextInt();
                switch (num) {
                    case 1:
                        array.randInput(10, 150);
                        array.consolOutputLR();
                        array.consolOutputRL();
                        break;
                    case 2:
                        array.consolInput();
                        array.consolOutputLR();
                        array.consolOutputRL();
                        break;
                }
            }

            System.out.println("Введите число для поиска в массиве: ");
            long z = in.nextInt();
            array.findIndexNumber(z);
            System.out.print("Массив, отсортированный методом пузырька по возрастанию: ");
            array.bubbleSorter();
            array.consolOutputLR();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
