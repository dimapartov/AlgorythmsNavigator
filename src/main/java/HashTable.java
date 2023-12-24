import java.util.LinkedList;

public class HashTable<T> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75d;
    private int elementsCount;
    private int tableCapacity;
    private LinkedList<T>[] slots;

    public HashTable() {
        this.tableCapacity = INITIAL_CAPACITY;
        this.slots = new LinkedList[tableCapacity];
        for (int i = 0; i < tableCapacity; i++) {
            slots[i] = new LinkedList<>();
        }
    }

    public double getLoadFactor() {
        return (double) this.size() / tableCapacity;
    }

    private void growIfNeeded() {
        if ((double) (this.size() + 1) / this.capacity() > LOAD_FACTOR) {
            this.grow();
        }
    }

    private void grow() {
        int newCapacity = this.tableCapacity * 2;
        LinkedList<T>[] newSlots = new LinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newSlots[i] = new LinkedList<>();
        }
        for (LinkedList<T> bucket : slots) {
            for (T entry : bucket) {
                int slot = Math.abs(entry.hashCode() % newCapacity);
                newSlots[slot].add(entry);
            }
        }
        this.slots = newSlots;
        this.tableCapacity = newCapacity;
    }

    public void put(T entry) {
        growIfNeeded();
        int slot = Math.abs(entry.hashCode() % tableCapacity);
        slots[slot].add(entry);
        elementsCount++;
    }

    public int size() {
        return this.elementsCount;
    }

    public int capacity() {
        return this.tableCapacity;
    }

    public int countCollisions() {
        int collisions = 0;
        for (LinkedList<T> bucket : slots) {
            if (bucket.size() > 1) {
                collisions++;
            }
        }
        return collisions;
    }

}