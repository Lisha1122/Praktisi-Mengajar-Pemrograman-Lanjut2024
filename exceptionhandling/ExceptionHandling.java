/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exceptionhandling;

/**
 *
 * @author Lisha Khaerunniswah
 */
public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[3]); // Ini akan menyebabkan ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Terjadi kesalahan: Indeks di luar batas array.");
        }

        System.out.println("Program terus berjalan setelah penanganan pengecualian.");
    }
}
