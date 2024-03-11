package set;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("orange");   //w setach nie może być duplikatów
        System.out.println(fruits.contains("apple"));
        System.out.println(fruits.size());
        System.out.println(fruits.isEmpty());

        Set<String> food = new HashSet<>();
        food.add("onion");
        food.add("potato");

        food.addAll(fruits);
        System.out.println(food.size());

        for (String item : food){
            System.out.println(item);
        }
    }
}
