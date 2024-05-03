
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lisha Khaerunniswah
 */
import java.util.Deque;
import java.util.ArrayDeque;

public class Dequeue {
      public static void main(String[] args) {
        Deque<Integer> numbers = new ArrayDeque<>();
        numbers.offerLast(1);
        numbers.offerLast(2);
        numbers.offerLast(3);
        while (!numbers.isEmpty()) {
            int next = numbers.pollLast();
            System.out.println(next);
        }
    }
}
