import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class SistemAntrianRumahSakit {
    private Queue<String> patientQueue = new LinkedList<>();

    public void addPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama pasien: ");
        String patientName = scanner.nextLine();

        if (patientName.isEmpty()) {
            System.out.println("Nama pasien tidak boleh kosong.");
            return;
        }

        patientQueue.add(patientName);
        System.out.println("Pasien " + patientName + " telah ditambahkan ke antrian.");

        // Write patient to operation file
        writePatientToOperationFile(patientName);
    }

    public void removePatient() {
        if (patientQueue.isEmpty()) {
            System.out.println("Tidak ada pasien dalam antrian.");
            return;
        }

        System.out.print("Masukkan nama pasien yang ingin dihapus: ");
        Scanner scanner = new Scanner(System.in);
        String patientName = scanner.nextLine();

        if (!patientQueue.contains(patientName)) {
            System.out.println("Pasien " + patientName + " tidak ada dalam antrian.");
            return;
        }

        patientQueue.remove(patientName);
        System.out.println("Pasien " + patientName + " telah dihapus dari antrian.");
    }

    public void viewPatients() {
        if (patientQueue.isEmpty()) {
            System.out.println("Tidak ada pasien dalam antrian.");
            return;
        }

        System.out.println("Daftar pasien dalam antrian:");
        int index = 1;
        for (String patient : patientQueue) {
            System.out.println(index + ". " + patient);
            index++;
        }
    }

    public void writePatientToOperationFile(String patientName) {
        String fileName = "c:/Users/Lisha Khaerunniswah/Documents/NetBeansProjects/OperationFile/src/patients.txt";

        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(patientName + "\n");
            System.out.println("Pasien " + patientName + " telah ditambahkan ke file operasi.");
        } catch (IOException e) {
            System.err.println("Error menulis ke file: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        SistemAntrianRumahSakit hospitalQueue = new SistemAntrianRumahSakit();

        while (true) {
            System.out.println("\nOpsi:");
            System.out.println("1. Tambah pasien ke antrian");
            System.out.println("2. Hapus pasien dari antrian");
            System.out.println("3. Lihat daftar pasien dalam antrian");
            System.out.println("4. Keluar");
            System.out.println("\nSilahkan Pilih opsi:");
             
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hospitalQueue.addPatient();
                    break;
                case 2:
                    hospitalQueue.removePatient();
                    break;
                case 3:
                    hospitalQueue.viewPatients();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem antrian rumah sakit.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}