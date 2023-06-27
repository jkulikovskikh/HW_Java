/* Реализуйте алгоритм сортировки пузырьком числового массива, результат 
после каждой итерации запишите в лог-файл
*/

package HW_Java.HW_2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class Task2 {
    int n;
    int [] array;

    private static Logger log = Logger.getLogger(Task2.class.getName());
	    
    Task2() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размерность массива");
        n = in.nextInt();
        array = new int[n];
        System.out.println("Введите массив");
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        in.close();

        System.out.println(Arrays.toString(array));
    }

    public int [] getSortedArray() {
        int min, max;
        boolean flag = true;

        while(flag)
        {
            flag = false;
            for(int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    min = array[i]; 
                    max = array[i - 1];
                    array[i] = max;
                    array[i - 1] = min;
                    if (!flag) {
                        flag = true;
                    }
                } 
            }
            log.info(Arrays.toString(array)+"\n");           
        }
        return array;
    }
}
