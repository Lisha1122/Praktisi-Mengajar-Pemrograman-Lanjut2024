import java.io.*;

public class Separator {
    public static void main(String[] args) {
        String files = "data" + File.separator + "example" + File.separator + "file.txt";
        System.out.println("Creating file " + files);
        File file = new File(files);
        System.out.println(file.getAbsolutePath());
    }
}