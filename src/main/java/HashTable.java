import java.util.LinkedList;

public class HashTable<T> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75d;
    private int elementsCount;
    private int tableCapacity;

    public HashTable() {
    }

    public double getLoadFactor() {
        return (double) this.elementsCount / tableCapacity;
    }

    private void growIfNeeded() {
        if ((double) (this.elementsCount + 1) / this.tableCapacity > LOAD_FACTOR) {
            this.grow();
        }
    }
    private void grow() {
        int newCapacity = this.tableCapacity * 2;
        LinkedList<T>[] newSlots = new LinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newSlots[i] = new LinkedList<>();
        }
        for (bucket : slots) {
            for ( entry : bucket) {
                int slot = Math.abs(entry.hashCode() % newCapacity);
                newSlots[slot].add(entry);
            }
        }
        this.slots = newSlots;
        this.tableCapacity = newCapacity;
    }

    public void put() {
        growIfNeeded();
    }

}