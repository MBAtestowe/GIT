public class HomeworkStudent {
/*    Stwórz 3 obiekty klasy student. Przypisz wartości do pól.
      Stwórz tablicę i dodaj studentów do tablicy.
      Przejdź przez studentów w tablicy i wywołaj wszystkie 4 metody.
 */
public static void main(String[] args) {

    Student student1 = new Student();
    student1.imie = "Zuzanna";
    student1.nazwisko = "Kowalska";
    student1.nick = "Zuza";
    student1.email = "zuza@gmail.com";
    student1.numerIndeksu = 789456123;

    Student student2 = new Student();
    student2.imie = "Maciej";
    student2.nazwisko = "Dąbrowski";
    student2.nick = "MCD";
    student2.email = "maciekdab@onet.pl";
    student2.numerIndeksu = 741258963;

    Student student3 = new Student();
    student3.imie = "Karolina";
    student3.nazwisko = "Nowak";
    student3.nick = "Karolina";
    student3.email = "KarolaN@wp.pl";
    student3.numerIndeksu = 589674123;

    Student [] bazaStudentów = {student1, student2,student3};

    for (int i=0; i<bazaStudentów.length; i++){
        bazaStudentów[i].przedstawSie();
        bazaStudentów[i].zalogujSie();
        bazaStudentów[i].podajEmail();
        bazaStudentów[i].podajNumerIndeksu();
    }
}
}
