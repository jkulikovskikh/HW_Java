/*
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре 
будут повторяющиеся имена с разными телефонами, их необходимо считать,
как одного человека с разными телефонами. Вывод должен быть отсортирован 
по убыванию числа телефонов.
 */

package HW_Java.HW_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task {
    HashMap<String, ArrayList<String>> phoneHashMap = new HashMap<>();
    ArrayList<Integer> numbersPhone = new ArrayList<>();

    String inputString;

    public Task() {
        do {
            Scanner in = new Scanner(System.in);
            inputString = in.nextLine();
            if (!inputString.equals("Q")) {
                getPhoneBook(inputString);
            } else {
                in.close();
            }
        } while (!inputString.equals("Q"));
        System.out.println(phoneHashMap);
    }

    private void getPhoneBook(String input) {
        String[] s = input.split(" ");

        if (phoneHashMap.containsKey(s[0])) {
            phoneHashMap.get(s[0]).add(s[1]);
        } else {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(s[1]);
            phoneHashMap.put(s[0], arrayList);
        }
    }

    public void sortedPhoneBook() {
        for (Map.Entry<String, ArrayList<String>> p : phoneHashMap.entrySet()) {
            numbersPhone.add(p.getValue().size());
        }

        Collections.sort(numbersPhone);
        Collections.reverse(numbersPhone);

        int count = 0;
        for (int i = 0; i < numbersPhone.size(); i++) {
            for (Map.Entry<String, ArrayList<String>> p : phoneHashMap.entrySet()) {
                if (p.getValue().size() == numbersPhone.get(i)) {
                    count++;
                    if (count <= phoneHashMap.size()) {
                        System.out.println(p);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
