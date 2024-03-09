package files;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Gosia\\Desktop\\GIT\\IntelliJ\\src\\files\\test.txt");

        if(file.delete()){
            System.out.println("File has been deleted");
        } else {
            System.out.println("This file does not exist");
        }
    }
}
