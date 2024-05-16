/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

/**
 *
 * @author Lisha Khaerunniswah
 */
public class MultipleException{
    public static void main(String[] args) {
        try {
            String text = null;
            System.out.println(text.length()); // Ini akan menyebabkan NullPointerException
            int num = Integer.parseInt("abc"); // Ini akan menyebabkan NumberFormatException
        } catch (NullPointerException e) {
            System.out.println("Terjadi kesalahan: Variabel tidak diinisialisasi.");
        } catch (NumberFormatException e) {
            System.out.println("Terjadi kesalahan: Format angka tidak valid.");
        }

        System.out.println("Program terus berjalan setelah penanganan pengecualian.");
    }
}
