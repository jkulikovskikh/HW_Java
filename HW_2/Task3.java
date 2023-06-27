/*
Дана json-строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */

package HW_Java.HW_2;

public class Task3 {
    
    String s = "[\"{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

    public String[][] getSplitString(String s) {

        String [][] p = new String[3][5];
        String name =  "";
        String estimate =  "";
        String subject =  "";
        String ss =  "";
        
        for (String str: s.split("\\\"|\\.|\\,|\\:|\\{|\\}|\\[|\\]")) {
            ss += str;
            ss = ss.trim() + " ";
        }

        int count = 0;
        for (String str: ss.split(" ")) {
            str = str.trim();
            if (str.compareTo("фамилия") == 0) {
                count ++;
                continue;           
            } else if (count == 1 && str.compareTo("оценка") != 0 && str.compareTo("предмет") != 0) {
                name += str;
                name += " ";
            } else if (str.compareTo("оценка") == 0) {
                count ++;
                continue;
            } else if (count == 2 && str.compareTo("фамилия") != 0 && str.compareTo("предмет") != 0) {
                estimate += str;
                estimate += " ";
            } else if (str.compareTo("предмет") == 0) {
                count ++;
                continue;
            } else if (count == 3 && str.compareTo("фамилия") != 0 && str.compareTo("оценка") != 0) {
                subject += str;
                subject += " ";
                count = 0;
            }
        }  
        
        p[0] =  name.split(" ");
        p[1] = estimate.split(" ");
        p[2] =  subject.split(" ");

        return p;
    }

    String [][] parameters =  getSplitString(s);

    public String getPhrase() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < parameters[0].length; i++) {
            result.append("Студент ".concat(parameters[0][i])).append(" ");
            result.append("получил ".concat(parameters[1][i])).append(" ");
            result.append("по предмету ".concat(parameters[2][i])).append(".");
            if (i != (parameters[0].length - 1)) {
                result.append("\n");
            }
        }  
        return result.toString(); 
    }
}
