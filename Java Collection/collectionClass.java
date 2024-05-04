/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lisha Khaerunniswah
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class collectionClass {
    public static void main(String[] args) {
        Collection<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.addAll(Arrays.asList(3, 4));
        
        numbers.remove(2);
        
        System.out.println(numbers.contains(2));              
        
        for (var number: numbers) {
            System.out.println(number);
        }
    }
}
