import java.util.Scanner;

public class HomeworkCalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello. Give me your favourite number,please.");
        int number = scanner.nextInt();
        System.out.println("What is your second favorite number?");
        int number2 = scanner.nextInt();

        HomeworkCalcualtor calcualtor = new HomeworkCalcualtor();

        System.out.println("Addition= " +calcualtor.addition(number,number2));
        System.out.println("Subtraction= " +calcualtor.subtraction(number,number2));
        System.out.println("Multiplication= " +calcualtor.multiplication(number,number2));
        System.out.println("Division= " +calcualtor.division(number,number2));
        System.out.println("Modulo= " +calcualtor.modulo(number,number2));
    }
}
