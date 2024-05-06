Nama    : Lisha Khaerunniswah
NIM     : 235150707111026

# JAVA COLLECTION
## A. Pengenalan Collection
   Collection adalah fungsi/bawaan dari bahasa pemrograman disebut sebagai container (yang mengumpulkan/berisi data-data yang mirip seperti Array). Di dalam java telah menyediakan class-class collection yang bisa langsung digunakan tanpa adanya tambahan library. Semua clas yang ada di java adalah generic class.

Di java collection terdapat :
1. Interfaces 
    ini adalah contract representasi dari collection.
2. Implementations
    kita juga dapat menggunakan implementasi yang sudah dibuat oleh java.
3. Algorithms
    Java juga menyediakan algoritma yang umu digunakan di collection, seperti pencarian dan pengumpulan data.

# Iterable & Iterator Interface
## 1. Iterable Interface
- Iterable adalah parent untuk semua collection di Java, kecuali Map
- Iterable sendiri sangat sederhana, hanya digunakan agar mendukung for-each loop
- Karena semua collection pasti implement iterable, secara otomatis maka semua collection di Java mendukung perulangan for-each, jadi bukan hanya Array

## Kode Iterable
```sh
import java.util.List;

public class iterableClass {
    public static void main(String[] args) {
        Iterable<String> names = List.of("Lisha");
        
        for(var name: names) {
            System.out.println(name);
        }
    }
            
}
```

## 2.Iterator Interface
- For-each di Iterable bisa terjadi karena ada method iterator() yang 
mengembalikan object Iterator
- Iterator adalah interface yang mendefinisikan cara kita melakukan mengakses element di collection secara sequential
- For-each sendiri muncul sejak Java 5, sebelum Java 5 untuk melakukan iterasi collection, biasanya dilakukan manual menggunakan Iterator object

# Collection Interface
- Selain Iterable interface, parent class semua collection di Java adalah Collection
- Iterable interface digunakan sebagai kontrak untuk meng-iterasi data secara sequential
- Collection merupakan kontrak untuk memanipulasi data collection, seperti menambah, menghapus dan mengecek isi data collection
- Tidak ada direct implementation untuk Collection, karena collection nanti akan dibagi lagi menjadi List, Set dan Queue.

## Kode menambah, Menghapus, dan Mengecek Data di Collection
```sh
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
```

## List Interface
- List adalah struktur data collection yang memiliki sifat sebagai berikut 
1. Elemen di list bisa duplikat, artinya bisa memasukkan data yang sama
2. Data list berurut sesuai dengan posisi kita memasukkan data
3. List memiliki index, sehingga kita bisa menggunakan nomor index untuk mendapatkan element di list

Di Java ada beberapa implementasi List, dan dapat dipilih sesuai dengan kebutuhan kita, diantaranya terdapat:

## 1. Array List Class
- ArrayList adalah implementasi dari List menggunakan array
- Default kapasitas array di ArrayList adalah 10
- Namun ketika kita memasukkan data dan array sudah penuh, maka secara otomatis ArrayList akan membuat array baru dengan kapasitas baru dengan ukuran kapasitas lama + data baru

## Queue Interface
- Queue adalah implementasi dari struktur data Antrian atau FIFO (First In First Out)

## Array Dequeue vs LinkedList vs Priority Queue
- ArrayDeque menggunakan array sebagai implementasi queue nya
- LinkedList menggunakan double linked list sebagai implementasi queue nya
- PriorityQueue menggunakan array sebagai implementasi queue nya, namun diurutkan mennggunakan Comparable atau Comparator

## Kode Queue
```sh
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
```

## Dequeue Interface
-  Deque singkatan dari double ended queue, artinya queue yang bisa beroperasi dari depan atau belakang
- Jika pada queue, operasi yang didukung ada FIFO, namu pada deque, tidak hanya FIFO, namun juga mendukung LIFO (Last In First Out)
- Bisa dibilang deque adalah implementasi struktur data antrian dan stack (tumpukan)

## Kode Dequeue
```sh
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
```

## Map Interface

## Map
- Map adalah struktur data collection yang berisikan mapping antara key dan value
- Dimana key di map itu harus unik, tidak boleh duplikat, dan satu key cuma boleh mapping ke satu key
- Map sebenarnya mirip dengan Array, cuma bedanya kalo di Array, key adalah index (integer), sedangkan di Map, key nya bebas kita tentukan sesuai keinginan kita

## HashMap
- HashMap adalah implementasi Map yang melakukan distribusi key menggunakan hashCode() function
- Karena HashMap sangat bergantung dengan hashCode() function, jadi pastikan kita harus membuat function hashCode seunik mungkin, karena jika terlalu banyak nilai hashCode() yang sama, maka pendistribusian key nya tidak akan optimal sehingga proses get data di Map akan semakin lambat
- Di HashMap pengecekan data duplikat dilakukan dengan menggunakan method equals nya

## Kode Dequ
```sh
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
```
