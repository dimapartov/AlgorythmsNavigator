public class Main {
    public static void main(String[] args) {
        HashTable<String> stringHashTable = new HashTable<>();
        stringHashTable.put(1, "One");
        stringHashTable.put(2, "Two");
        stringHashTable.put(3, "Three");

        System.out.println(stringHashTable.get(1)); // Output: One
        System.out.println(stringHashTable.containsKey(2)); // Output: true

        stringHashTable.remove(3);
        System.out.println(stringHashTable.containsKey(3)); // Output: false
    }
}