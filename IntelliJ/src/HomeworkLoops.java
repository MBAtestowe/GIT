public class HomeworkLoops {
    /* 1. Wypisz liczby z zakresu 1-100 podzielne przez 3.
       2. Odwróć elementy tablicy [1,3,5,7,0] -> [0,7,5,3,1].
     */
    public static void main(String[] args) {
        //Ad.1.
        for (int x = 1; x <= 100; x++) {
            if (x % 3 == 0) {
                System.out.println("Number divisible by 3=" + x);
            }
        }
        //Ad.2.
        int[] numbers = {1, 3, 5, 7, 0};

        for (int i = 0; i < (numbers.length / 2); i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);

        }
    }
}

