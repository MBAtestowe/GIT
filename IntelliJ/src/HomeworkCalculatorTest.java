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
        calcualtor.subtraction(1,2);
        calcualtor.multiplication(1,2);
        calcualtor.division(1,2);
        calcualtor.modulo(1,2);
    }
}
