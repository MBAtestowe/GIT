import java.util.Scanner;

public class HomeworkIf {
    /* Zapytaj użytkownia o wiek. W przypadku gdy ma mniej niż 18 lat wypisz
     na ekranie informacje, że nie może kupić alkoholu. Gdy ma więcej niż 18 lat
     to podziękuj za zakupy.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello. How old are you?");
        int age = scanner.nextInt();
        if (age<0){
            System.out.println("Please enter correct value.");
        } else if (age>=18){
            System.out.println("Thank you for shopping.");
        } else {
            System.out.println("Sorry. You cannot buy alcohol.");
        }
    }
}
