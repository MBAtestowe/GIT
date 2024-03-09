package files;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Gosia\\Desktop\\GIT\\IntelliJ\\src\\files\\test.txt");
        if (file.createNewFile()){
            System.out.println("I created a new file.");
        } else {
            System.out.println("The file already exists.");
        }
    }
}
