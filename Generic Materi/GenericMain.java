public class GenericMain {
        public static void main(String[] args) {
            // Membuat objek GenericClass dengan tipe String
            GenericClass<String> stringGeneric = new GenericClass<>("Hello, Generics!");
            stringGeneric.displayInfo(); // Output: Data: Hello, Generics!
    
            // Membuat objek GenericClass dengan tipe Integer
            GenericClass<Integer> integerGeneric = new GenericClass<>(123);
            integerGeneric.displayInfo(); // Output: Data: 123
    
            // Membuat objek GenericClass dengan tipe Boolean
            GenericClass<Boolean> booleanGeneric = new GenericClass<>(true);
            booleanGeneric.displayInfo(); // Output: Data: true
        }
    }

