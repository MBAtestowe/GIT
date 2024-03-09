package HomewrokException;

import java.util.Scanner;

public class Exception {
//  Pobierz wiek od użytkownika. Jezeli bedzie mniejszy od zera,to wyrzuc wyjątek InvalidAgeException.
//    Jeżeli mamy >= 18 lat to wypisz że osoba jest pełnoletnia.

    public static void main(String[] args) throws InvalidAgeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        if (age<0){
            throw new InvalidAgeException("Your age is not valid.");
        } else if (age>18) {
            System.out.println("Thank you. You are of legal age.");
        } else {
            System.out.println("You are not of legal age.");
        }
    }
}
