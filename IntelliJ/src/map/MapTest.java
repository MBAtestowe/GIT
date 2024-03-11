package map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> students = new HashMap<>();
        students.put(1,"Basia");
        students.put(2,"Kasia");
        students.put(3,"Asia");
        students.put(2,"Krysia"); // klucz 2 zostanie nadpisany

        System.out.println(students.get(1));
        System.out.println(students.get(2));

        Map<Integer,String> otherStudents = new HashMap<>();
        otherStudents.putAll(students);

        System.out.println(students.containsKey(1));
        System.out.println(students.containsValue("Gosia"));

        System.out.println(students.size());
        System.out.println(students.isEmpty());

        students.remove(1);
        System.out.println(students.size());

        for(Integer key: students.keySet()){
            System.out.println(key);
            System.out.println(students.get(key));
        }

        for (String student : students.values()){
            System.out.println(student);
        }
    }
}
