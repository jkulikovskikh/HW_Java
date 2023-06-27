package HW_Java.HW_2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class Main  {
    public static void main(String[] args) throws IOException {

    //    Task1 task1 = new Task1();
    //    System.out.println(task1.getWhere()); 
    
    //    Task2 task2 = new Task2();
    //    System.out.println(Arrays.toString(task2.getSortedArray()));

    //    Task3 task3 = new Task3();
    //    System.out.println(task3.getPhrase());

        Task4 task4 = new Task4();
        Logger logger = Logger.getLogger(Task4.class.getName()); 
	    try {
		    FileHandler fh = new FileHandler(".\\HW_Java\\HW_2\\log.txt");
		    logger.addHandler(fh);	
	    }  catch (IOException o) {
            o.printStackTrace();
		    logger.log(Level.SEVERE,"Не удалось создать файл лога из-за ошибки ввода-вывода.");
	    }
        task4.calculation();
    }
}
