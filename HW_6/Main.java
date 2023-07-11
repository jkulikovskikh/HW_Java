package HW_Java.HW_6;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Laptop laptop1 = new Laptop (4,  128, "Windows", 15.6, "black", 19000);
        Laptop laptop2 = new Laptop (8,  256, "Windows", 14.1, "silver", 25000);
        Laptop laptop3 = new Laptop (8,  128, "Windows", 14.1, "silver", 17000);
        Laptop laptop4 = new Laptop (6,  128, "Windows", 15.6, "grey", 20000);
        Laptop laptop5 = new Laptop (8,  512, "Linux", 15.6, "silver", 36000);
        
        System.out.println("------------Множество ноутбуков------------");
        System.out.println(laptop1);
        System.out.println(laptop2);
        System.out.println(laptop3);
        System.out.println(laptop4);
        System.out.println(laptop5);
        System.out.println("-------------------------------------------");

        HashMap<Integer, Laptop> laptopMap = new HashMap<>();
        laptopMap.put(1,laptop1);
        laptopMap.put(2,laptop2);
        laptopMap.put(3,laptop3);
        laptopMap.put(4,laptop4);
        laptopMap.put(5,laptop5);

        HashMap<Integer, String> laptopFilter = new HashMap<>();
        String input;
        System.out.println("Введите цифры, соответствующие необходимым критериям, и их минимальные значения" + "\n"+
                            "('один критерий' пробел 'минимальное значение'):" + "\n" +
                            "1 - ОЗУ" + "\n" +
                            "2 - Объем жесткого диска" + "\n" +
                            "3 - ОС" + "\n" +
                            "4 - Размер экрана" + "\n" +
                            "5 - Цвет" + "\n" +
                            "6 - Цена в рублях" + "\n" +
                            "Q - выход");
        System.out.println("-------------------------------------------");
        do {
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            if (!input.equals("Q")) {
                String [] s = input.split(" ");
                laptopFilter.put(Integer.parseInt(s[0]), s[1].toLowerCase());
            } else {
                in.close();
            }
        } while (!input.equals("Q"));
      
        System.out.println("----------Отфильтрованные ноутбуки---------");
        for (int i = 1; i <= laptopMap.size() ; i++) {
            laptopMap.get(i).getFiltredLaptop(laptopFilter);
        }
    }
}
