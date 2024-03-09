package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Gosia\\Desktop\\GIT\\IntelliJ\\src\\files\\test.txt");
        Scanner myScanner = new Scanner(file);
        while (myScanner.hasNext()){
            String line = myScanner.nextLine();
            System.out.println(line);
        }
        myScanner.close();
    }
}
