/*
1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого 
запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
*/

package HW_Java.HW_2;

public class Task1 {
    String str = "\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"";

    public  String [][] getParameters(String s) { 
        String [][] p = new String[2][4];
        String str1 = "";
        String str2 = "";
        int count = 2;

        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (symbol == '\"') {
                continue;
            } else if (symbol == ':' || symbol == ',') {
                count++;
                if (symbol == ',') {
                   str2 += ' ' ; 
                }
            }
            else if (symbol != ':' && count%2 == 0) {
                str1 += symbol;

            } else if (count%2 != 0) {
                str2 += symbol;
            }
        }
        p[0] = str1.split(" ");
        p[1] = str2.split(" ");

        return p;
    }

    String [][] parameters = getParameters(str);

    public String getWhere() {
        StringBuilder result = new StringBuilder();
        
        result.append("Where ");
        for (int i = 0; i < parameters[0].length; i++) {
            if (parameters[1][i].compareTo("null") != 0) {
                result.append(parameters[0][i].concat(" = ")).append(parameters[1][i].concat(", "));
            } else if (parameters[1][i].compareTo("null") == 0 && i == parameters[0].length - 1) {
                result.deleteCharAt(result.toString().length() - 2);
            }
        }
        return result.toString();
    }
}
