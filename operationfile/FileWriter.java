import java.io.*;

public class FileWriter {
    public static void main(String[] args) {
        // Path ke file teks
        String fileName = "c:/Users/Lisha Khaerunniswah/Documents/NetBeansProjects/OperationFile/src/Documents.txt";
        System.out.println("Menulis ke file " + fileName);

        // Membuat objek File
        File file = new File(fileName);

        // Membuat aliran output file
        try {
            FileOutputStream fos = new FileOutputStream(file);

            // Menulis string ke file
            String data = "Hello, World!";
            byte[] bytes = data.getBytes();
            fos.write(bytes);
            fos.close();

            // Menampilkan pesan
            System.out.println("Berhasil menulis ke file!");
        } catch (IOException e) {
            // Menangani kesalahan menulis ke file
            System.err.println("Error menulis ke file: " + e.getMessage());
        }
    }
}