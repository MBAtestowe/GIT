package interview;

import java.util.HashMap;
import java.util.Map;

public class CountOccurencies {
    // int [] numbers = new int [] {1,2,3,2,5,3}
    public static void main(String[] args) {
    countOccurencies(new int [] {1,2,3,2,5,3,3,3,3,3});
    }
    public static void countOccurencies(int [] numbers){
        Map<Integer,Integer> occurencies = new HashMap<>();
        for (int i =0; i<numbers.length; i++){
            if (occurencies.containsKey(numbers[i])){
                Integer value = occurencies.get(numbers[i]);
                occurencies.put(numbers[i], value+1);
            } else {
                occurencies.put(numbers[i],1);
            }
        }
        for (Integer key : occurencies.keySet()){
            System.out.println("Number "+ key + " occurs "+ occurencies.get(key) + " times" );
        }
        //System.out.println("Ilość elementów w mapie to:"+ occurencies.size());
    }
}
