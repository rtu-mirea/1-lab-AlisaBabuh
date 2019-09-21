package com.company;
import java.util.Scanner;
public class Array {
    private int n;
    private int x[];
    //Неправильный ввод
    Array(int n) throws Exception {
        if (n <= 0) throw new Exception(new String("Недопустимое количество элементов."));
        this.n = n;
        this.x = new int[this.n];
    }
    //Заполнение массива случайными числами
    void randInput(long min, long max) {
        for (int i = 0; i < n; i++) {
            x[i] = (int) (Math.random() * ++max + min);
        }
    }
    //Ввод массива с клавиатуры
    void consolInput(){
        System.out.println("Ваш массив: ");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
    }
    //Вывод массива справа налево
    void consolOutputRL() {
        System.out.println("(Вывод массива справа налево)");
        for (int i = n-1; i >= 0; i--) {
            System.out.println(x[i]);
        }
    }
    //Вывод массива слева направо
    void consolOutputLR() {
        System.out.println("(Вывод массива слева направо)");
        for (int i:x) {
            System.out.println(i);
        }
    }
    //Поиск в массиве заданного числа
    void findIndexNumber(long z) {
        int ind = -1;
        for ( int i = 0; i < n; i++) {
            if (x[i]==z) {
                ind = i;
                break;
            }
        }
        if ( ind == -1)
            System.out.println("Число " + z + " не присутствует в массиве.");
        else
            System.out.println("Число " + z + " присутствует в массиве. Его индекс = " + ind);
    }
    //Перестановка элемнтов
    void toSwap(int first, int second){
        int hi = x[first];
        x[first] = x[second];
        x[second] = hi;
    }
    //Метод пузырька
    void bubbleSorter() {
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (x[j] > x[j + 1])
                    toSwap(j, j + 1);
            }
        }
    }
}
