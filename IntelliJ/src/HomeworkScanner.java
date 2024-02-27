import java.util.Scanner;

public class HomeworkScanner {
/*  Napisz program, który poprosi użytkownika o podanie dwóch liczb,
 a następnie wykonan nanich podstawowe operacjematematyczne */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello. Give me your favourite number,please.");
        int number = scanner.nextInt();
        System.out.println("What is your second favorite number?");
        int number2 = scanner.nextInt();

        int addition = number + number2;
        int subtracion = number - number2;
        int multiplication = number * number2;
        int division = number / number2;
        int modulo = number % number2;

        System.out.println("How wonderful!\n" + "Adding these numbers equals: " + addition
        + "\nSubtracting equals: " + subtracion
        + "\nMultiplication equals: " + multiplication
        + "\nDivision equals: " + division
        + "\nModulo equals: " + modulo);

    }
}
