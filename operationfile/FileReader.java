import java.io.*;

public class FileReader {
    public static void main(String[] args) {
        // Path ke file teks
        String fileName = "c:/Users/Lisha Khaerunniswah/Documents/NetBeansProjects/OperationFile/src/Documents.txt";
        System.out.println("Membaca file " + fileName);

        // Membuat objek File
        File file = new File(fileName);

        // Membuat aliran input file
        try {
            FileInputStream fis = new FileInputStream(file);

            // Membaca isi file
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            // Menampilkan isi file
            System.out.println("Isi file: " + new String(data));
        } catch (IOException e) {
            // Menangani kesalahan membaca file
            System.err.println("Error membaca file: " + e.getMessage());
        }
    }
}