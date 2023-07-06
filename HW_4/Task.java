/*
Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном 
порядке и каждый из их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка.
2) Сложите два числа и верните сумму в виде связанного списка. Одно или 
два числа должны быть отрицательными.
 */

package HW_Java.HW_4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Task {
    String number1;
    String number2;

    Deque<Integer> deque1 = new ArrayDeque<>();
    Deque<Integer> deque2 = new ArrayDeque<>();
    Deque<Integer> dequeNumber1 = new ArrayDeque<>();
    Deque<Integer> dequeNumber2 = new ArrayDeque<>();

    int numberInt1;
    int numberInt2;

    private Deque<Integer> getDequeFromString(String str) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (symbol == '-') {
                deque.addFirst(-1);
            } else {
                deque.addFirst(Character.getNumericValue(symbol));
            }
        }
        return deque;
    }

    private boolean getFlagNegative(Deque<Integer> deque) {
        boolean flag;
        if (deque.getLast() == -1) {
            flag = true;
            deque.pollLast();
        } else {
            flag = false;
        }
        return flag;
    }

    private boolean checkN1MoreN2 (Deque<Integer> deque1, Deque<Integer> deque2) {
        boolean flag = false;
        int i = 0;
        int j = 0;
        int a1;
        int a2;

        Iterator<Integer> iterator1 = deque1.iterator();
        Iterator<Integer> iterator2 = deque2.iterator();;

        if (deque1.size() > deque2.size()) {
            return  true;
        } else if (deque1.size() == deque2.size()) {
            while (iterator1.hasNext()) {
                i++;
                a1 = iterator1.next();
                while (iterator2.hasNext()) {
                    j++;
                    a2 = iterator1.next();
                    if (i == j && a1 > a2) {
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    public Task() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число n1");
        number1 = in.next();
        System.out.println("Введите целое число n2");
        number2 = in.next();
        in.close();
        dequeNumber1 = getDequeFromString(number1);
        dequeNumber2 = getDequeFromString(number2);

        System.out.println(dequeNumber1 +  " - n1");
        System.out.println(dequeNumber2 +  " - n2");
    }

    public void getMultiplication() {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> listResult = new LinkedList<>(); 
        
        deque1.addAll(dequeNumber1);
        deque2.addAll(dequeNumber2);

        int a1, a2;
        int result;
        result = 0;

        boolean flag1 = getFlagNegative(deque1);
        boolean flag2 = getFlagNegative(deque2);

        Iterator<Integer> iterator1;
        Iterator<Integer> iterator2;
        if (deque2.size() >= deque1.size()) {
            iterator2 = deque1.iterator();
        } else {
            iterator2 = deque2.iterator();
        }

        while (iterator2.hasNext()) {
            a2 = iterator2.next();

            if (deque2.size() >= deque1.size()) {
                iterator1 = deque2.iterator();
            } else {
                iterator1 = deque1.iterator();
            }
            while (iterator1.hasNext()) {
                a1 = iterator1.next();

                result += a1 * a2;
                if (result >= 10) {
                    list.add(result % 10);
                    result = result / 10;
                    if (!iterator1.hasNext()) {
                        list.add(result);
                    }
                } else {
                    list.add(result);
                    result = 0;
                }
            }

            if (!listResult.isEmpty()) {
                list.addFirst(0);
                listResult.addLast(0);

                int element = 0;
                LinkedList<Integer> list_ = new LinkedList<>();
                
                while (!list.isEmpty()) {
                    if (!listResult.isEmpty()) {
                        element += listResult.pop() + list.pop();
                    } else {
                        element += list.pop();
                    }
                    if (element >= 10) {
                        list_.add(element % 10);
                        element /= 10;
                    } else {
                        list_.add(element);
                        element = 0;
                    }
                }
                while (!list_.isEmpty()) {
                    listResult.add(list_.pop());
                }
            } else {
                while (!list.isEmpty()) {
                    listResult.add(list.pop());
                }
                result = 0;
            }
        }
        if ((flag1 && !flag2) || (flag2 && !flag1)) {
            listResult.add(-1);
        }
        System.out.println(listResult + " - произведение");

        deque1.clear();
        deque2.clear();
    }

    public void getSum() {
        LinkedList<Integer> listResult = new LinkedList<>();
        
        deque1.addAll(dequeNumber1);
        deque2.addAll(dequeNumber2);

        int result = 0;
        int i;

        boolean flag1 = getFlagNegative(deque1);
        boolean flag2 = getFlagNegative(deque2); 
        
        boolean flagN1MoreN2 = checkN1MoreN2(deque1, deque2); 

        if (deque1.size() > deque2.size()) {
            i = deque1.size() - deque2.size();
            while (i != 0) {
                deque2.addLast(0);
                i--;
            }
        } else if (deque2.size() > deque1.size()) {
            i = deque2.size() - deque1.size();
            while (i != 0) {
                deque1.addLast(0);
                i--;
            }
        }

        while (!deque1.isEmpty()) {
            if ((flag1 && !flag2) || (flag2 && !flag1)) {
                if (flagN1MoreN2) {
                    result += deque1.pop() - deque2.pop();
                } else {
                    result += deque2.pop() - deque1.pop();
                }
            } else {
                result += deque1.pop() + deque2.pop();
            }

            if (result >= 10) {
                listResult.add(result % 10);
                result /= 10;
                if (deque1.isEmpty()) {
                    listResult.add(result);
                }
            } else if (result < 0 && result > -10) {
                listResult.add(10 - Math.abs(result));
                result = -1;
            } else if (result <= -10) {
                listResult.add(Math.abs(result) % 10);
                result /= 10;
            } else if (result == 0) {
                if (!deque1.isEmpty()) {
                    listResult.add(result);
                }
            } else if (result > 0 && result < 10) {
                listResult.add(result);
                result = 0;
            }
        }
        while (listResult.getLast() == 0) {
            listResult.pollLast();
        }
        if ((flag1 && flag2) || (flag1 && flagN1MoreN2) || (flag2 && !flagN1MoreN2)) {
            listResult.addLast(-1);
        }
        System.out.println(listResult + " - сумма"); 
        
        deque1.clear();
        deque2.clear();
    }  
}