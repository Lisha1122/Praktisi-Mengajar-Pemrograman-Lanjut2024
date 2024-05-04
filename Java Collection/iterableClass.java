/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lisha Khaerunniswah
 */
import java.util.List;

public class iterableClass {
    public static void main(String[] args) {
        Iterable<String> names = List.of("Lisha");
        
        for(var name: names) {
            System.out.println(name);
        }
    }
            
}

