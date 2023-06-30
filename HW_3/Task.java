/*
    Пусть дан произвольный список целых чисел.

    1) Нужно удалить из него чётные числа
    2) Найти минимальное значение
    3) Найти максимальное значение
    4) Найти среднее значение
 */

package HW_Java.HW_3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Collections;

public class Task {

    int n;
    int a;
    int b; 

    ArrayList<Integer> numbers = new ArrayList<>();

    Task() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размерность списка");
        n = in.nextInt();
        System.out.println("Введите нижнюю границу списка");
        a = in.nextInt();
        System.out.println("Введите верхнюю границу списка");
        b = in.nextInt();
        in.close();
        for (int i = 0; i < n; i++) {
            numbers.add(i, (int)((Math.random() * (b - a + 1) + a)));
        }

        System.out.println(numbers);
    }

    public void getOddNumbersList() {
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(numbers);
    }

    public void getMinList() {
        if (!numbers.isEmpty()) {
            System.out.println("min = " + Collections.min(numbers));
        } else {
            System.out.println("Невозможно вычислить минимальное значение, т.к. список пустой");
        }
    }

    public void getMaxList() {
        if (!numbers.isEmpty()) {
            System.out.println("max = " + Collections.max(numbers));
        } else {
            System.out.println("Невозможно вычислить максимальное значение, т.к. список пустой");
        }
    }

    public void getMeanList() {
        if (!numbers.isEmpty()) {
            double result = 0;
            for (Integer integer : numbers) {
                result += integer;
            }
            result /= numbers.size();
            System.out.println("mean = " + result);
        } else {
            System.out.println("Невозможно вычислить среднее значение, т.к. список пустой");
        }
    }
}
