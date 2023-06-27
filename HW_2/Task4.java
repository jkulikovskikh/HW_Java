/*
К калькулятору из предыдущего ДЗ добавить логирование.
 */

package HW_Java.HW_2;

import java.util.Scanner;
import java.util.logging.*;

public class Task4 {

    double n1;
    double n2;
    String operation;

	Logger logger = Logger.getLogger(Task4.class.getName()); 

    public Task4() {
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
        double result = 0;
        switch (operation) {
            case "+":
                result = n1 + n2;
	            logger.log(Level.INFO,  "n1 + n2 = " + Double.toString(result));
                break;
            case "-":
                result = n1 - n2;
	            logger.log(Level.INFO,  "n1 - n2 = " + Double.toString(result));
                break;
            case "*":
                result = n1 * n2;
	            logger.log(Level.INFO,  "n1 * n2 = " + Double.toString(result));
                break;
            case "/":
                if (n2 != 0) {
                    result = n1 / n2;
	                logger.log(Level.INFO,  "n1 / n2 = " + Double.toString(result));
                    break;
                } else {
	                logger.log(Level.SEVERE,  "Деление на 0");
                    }
                break;
            default:
	            logger.log(Level.WARNING,  "Некорректно введена арифметическая операция");
                break;
        }
    }
}
