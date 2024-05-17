
import java.io.File;
import java.io.IOException;

public class BuatDirectory {
    public static void main(String[] args) {
        // Membuat direktori
        File dir1 = new File("Folder1");
        boolean isDirCreated = dir1.mkdir();
        System.out.println("Direktori dibuat: " + isDirCreated);
        
        // Membuat file di dalam direktori tersebut
        File file1 = new File(dir1, "File1.txt");
        try {
            boolean isFileCreated = file1.createNewFile();
            System.out.println("File dibuat: " + isFileCreated);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Menampilkan path file
        System.out.println("Path file: " + file1.getPath());
        
        // Memeriksa apakah itu adalah direktori
        System.out.println("Apakah ini direktori: " + dir1.isDirectory());
    }
}
