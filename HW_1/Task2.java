/* Вывести все простые числа от 1 до 1000 */
package HW_Java.HW_1;

import java.util.Scanner;

public class Task2 {
    int n1;
    int n2;

    public Task2() {
        System.out.println("Введите число n1");
        Scanner input = new Scanner(System.in);
        n1 = input.nextInt();
        System.out.println("Введите число n2");
        n2 = input.nextInt();
        input.close();
    }

    public void getSimpleNumber() {
        int count;
        System.out.println("Простые числа от n1 до n2");
        for(int i = n1; i <= n2; i++) {
            count = 0;
            for(int j = 2; j <= i; j++) {
                if((i % j) == 0) {
                    count++;
                }
            }
            if(count == 1) {
                System.out.print(i + " ");
            }
            count = 0;
        }
    }
}
