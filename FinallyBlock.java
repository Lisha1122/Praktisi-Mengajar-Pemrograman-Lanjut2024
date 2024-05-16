/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

/**
 *
 * @author Lisha Khaerunniswah
 */
public class FinallyBlock {
    public static void main(String[] args) {
        try {
            int division = 10 / 0; // Ini akan menyebabkan ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Terjadi kesalahan: Pembagian dengan nol.");
        } finally {
            System.out.println("Blok finally dieksekusi.");
        }

        System.out.println("Program terus berjalan setelah penanganan pengecualian.");
    }
}

