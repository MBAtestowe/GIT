package listy;

import drivers.ChromeDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListyTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Kasia");
        names.add("Tomek");
        names.add("Ania");
        names.add("Tomek");

        System.out.println(names.get(0));
        System.out.println(names.indexOf("Tomek"));
        System.out.println(names.lastIndexOf("Tomek"));
        System.out.println(names.contains("Ania"));
        System.out.println(names.size());
        System.out.println(names.isEmpty());

        List<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);

        System.out.println(numbers.get(0));
        System.out.println(numbers.indexOf(2));
        System.out.println(numbers.lastIndexOf(1));
        System.out.println(numbers.contains(3));
        System.out.println(names.size());
        System.out.println(names.isEmpty());

        List<String> diffNames = new ArrayList<>();
        diffNames.addAll(names);

        List<ChromeDriver> chromeDriverList = new ArrayList<>();
        chromeDriverList.add(new ChromeDriver());

        for (int i =0;i<names.size();i++){
            System.out.println(names.get(i));
        }

        for (String name : names){
            System.out.println(name);
        }
    }
}
