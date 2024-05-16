/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

/**
 *
 * @author Lisha Khaerunniswah
 */
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void main(String[] args) {
        try {
            checkNumber(50); // Ini akan melempar pengecualian kustom
        } catch (CustomException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }

        System.out.println("Program terus berjalan setelah penanganan pengecualian.");
    }

    public static void checkNumber(int number) throws CustomException {
        if (number > 10) {
            throw new CustomException("Angka tidak boleh lebih dari 10.");
        }
        System.out.println("Angka valid.");
    }
}

