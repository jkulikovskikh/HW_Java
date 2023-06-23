/* Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены 
знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить выражение до верного 
равенства. Предложить хотя бы одно решение или сообщить, что его нет */

package HW_Java.HW_1;

import java.util.Scanner;

public class Task4 {

    String q;
    String w;
    String e;

    public Task4() {
        System.out.println("Введите двухзначное число q");
        Scanner input = new Scanner(System.in);
        q = input.next();
        System.out.println("Введите двухзначное число w");
        w = input.next();
        System.out.println("Введите двухзначное число e");
        e = input.next();
        input.close();
        System.out.println(q + " + " + w + " = " + e);
    }

    public int[] getNumber(String str) {

        int[] result = new int[2];

        for(int i = 0; i < 2; i++) {
            result[i] = -1;
        }

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (Character.isDigit(symbol)) {
                count++;
                if (count == str.length()) {
                    result[0] = Integer.parseInt(str);
                } else {
                    result[0] = Character.getNumericValue(symbol);
                }
            } else {
                result[1] = i;
            }
        }
        return result;
    }

    public void getExpression() {

        if (q.length() != 2 || w.length() != 2 || e.length() != 2) {
            System.out.println("Введены не двухзначные цифры");
            return;
        }

        int[] n1 = new int[2];
        int[] n2 = new int[2];
        int[] n3 = new int[2];
        int x, y;

        n1 = getNumber(q);
        n2 = getNumber(w);
        n3 = getNumber(e);

        int count = 0;
        if (n1[1] == 1 && n2[1] == 0) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    x = n1[0] * 10 + i;
                    y = j * 10 + n2[0];
                    if ((x + y) == n3[0]) {
                        count++;
                        System.out.println(x + " + " + y + " = " + n3[0]);
                    }
                }
            }
            if (count == 0) {
                System.out.println("Решения уравнения нет");
            }
        } else {
            return;
        }
    }
}
