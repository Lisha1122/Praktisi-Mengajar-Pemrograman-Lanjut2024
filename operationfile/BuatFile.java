import java.io.File;

public class BuatFile { 
    public static void main(String[] args) {
        File file1 = new File("Documents.txt");
        System.out.println("Path: " + file1.getAbsolutePath());
        System.out.println("Exists: " + file1.exists());
    }
}

