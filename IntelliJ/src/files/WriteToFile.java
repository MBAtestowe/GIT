package files;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\Gosia\\Desktop\\GIT\\IntelliJ\\src\\files\\test.txt");
        writer.write("New text.");
        writer.close();
    }
}
