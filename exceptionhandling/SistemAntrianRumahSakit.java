/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

/**
 *
 * @author Lisha Khaerunniswah
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SistemAntrianRumahSakit {
    private Queue<String> patientQueue = new LinkedList<>();
    private final int MAX_CAPACITY = 3;

    public void addPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama pasien: ");
        String patientName = scanner.nextLine();

        try {
            if (patientName.isEmpty()) {
                throw new IllegalArgumentException("Nama pasien tidak boleh kosong.");
            }

            if (patientQueue.size() >= MAX_CAPACITY) {
                throw new IllegalStateException("Antrian sudah penuh, mohon datang kembali nanti.");
            }

            patientQueue.add(patientName);
            System.out.println("Pasien " + patientName + " telah ditambahkan ke antrian.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void removePatient() {
        if (patientQueue.isEmpty()) {
            System.out.println("Tidak ada pasien dalam antrian.");
            return;
        }

        System.out.print("Masukkan nama pasien yang ingin dihapus: ");
        Scanner scanner = new Scanner(System.in);
        String patientName = scanner.nextLine();

        try {
            if (!patientQueue.contains(patientName)) {
                throw new IllegalArgumentException("Pasien " + patientName + " tidak ada dalam antrian.");
            }

            patientQueue.remove(patientName);
            System.out.println("Pasien " + patientName + " telah dihapus dari antrian.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
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

