/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

/**
 *
 * @author Lisha Khaerunniswah
 */
public class Throw {
    public static void main(String[] args) {
        try {
            validateAge(15); // Ini akan melempar pengecualian
        } catch (IllegalArgumentException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }

        System.out.println("Program terus berjalan setelah penanganan pengecualian.");
    }

    public static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Usia harus 18 atau lebih.");
        }
        System.out.println("Usia valid.");
    }
}
