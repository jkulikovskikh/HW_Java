/* Реализовать простой калькулятор */

package HW_Java.HW_1;

import java.util.Scanner;

public class Task3 {

    double n1;
    double n2;
    String operation;

    public Task3() {
        System.out.println("Введите число n1");
        Scanner input = new Scanner(System.in);
        n1 = input.nextDouble();
        System.out.println("Введите арифметическую операцию: +, -, /, *");
        operation = input.next();
        System.out.println("Введите число n2");
        n2 = input.nextDouble();
        input.close();
    }

    public void calculation() {
        double result;
        switch (operation) {
            case "+":
                result = n1 + n2;
                System.out.print("n1 + n2 = ");
                System.out.printf("%.4f\n", result);
                break;
            case "-":
                result = n1 - n2;
                System.out.print("n1 - n2 = ");
                System.out.printf("%.4f\n", result);
                break;
            case "*":
                result = n1 * n2;
                System.out.print("n1 * n2 = ");
                System.out.printf("%.4f\n", result);
                break;
            case "/":
                if (n2 != 0) {
                    result = n1 / n2;
                    System.out.print("n1 / n2 = ");
                    System.out.printf("%.4f\n", result);
                } else {
                    System.out.println("На 0 делить нельзя!");
                }
                break;
            default:
                System.out.println("Некорректно введена арифметическая операция");
                break;
        }
    }
}
