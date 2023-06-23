/* Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)*/

package HW_Java.HW_1;

import java.util.Scanner;

public class Task1 {
    int n;
    public Task1() {
        System.out.println("Введите целое число n");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        input.close();
    }

    public void getSum() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Cумма чисел от 1 до n: " + sum);
    }

    public void getFactorial() {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("n!: " + factorial);
    }
}
