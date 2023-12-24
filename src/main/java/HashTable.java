import java.util.Iterator;
import java.util.LinkedList;

public class HashTable<T> implements Iterable<Node<T>> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75d;
    private int elementsCount;
    private int tableCapacity;
    private LinkedList<Node<T>>[] slots;

    public HashTable() {
        this.tableCapacity = INITIAL_CAPACITY;
        this.slots = new LinkedList[tableCapacity];
        for (int i = 0; i < tableCapacity; i++) {
            slots[i] = new LinkedList<>();
        }
    }

    public double getLoadFactor() {
        return (double) this.getSize() / tableCapacity;
    }

    private void growIfNeeded() {
        if ((double) (this.getSize() + 1) / this.getCapacity() > LOAD_FACTOR) {
            this.grow();
        }
    }

    private void grow() {
        int newCapacity = this.tableCapacity * 2;
        LinkedList<Node<T>>[] newSlots = new LinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newSlots[i] = new LinkedList<>();
        }
        for (LinkedList<Node<T>> bucket : slots) {
            for (Node<T> entry : bucket) {
                int slot = Math.abs(entry.getKey().hashCode() % newCapacity);
                newSlots[slot].add(entry);
            }
        }
        this.slots = newSlots;
        this.tableCapacity = newCapacity;
    }

    public int getSize() {
        return this.elementsCount;
    }

    public int getCapacity() {
        return this.tableCapacity;
    }

    public int countCollisions() {
        int collisionCount = 0;
        for (LinkedList<Node<T>> bucket : slots) {
            if (bucket.size() > 1) {
                collisionCount += bucket.size() - 1;
            }
        }
        return collisionCount;
    }

    public void put(String key, T value) {
        growIfNeeded();
        int slot = findSlotNumber(key);
        LinkedList<Node<T>> bucket = slots[slot];
        for (Node<T> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        bucket.add(new Node<>(key, value));
        elementsCount++;
    }

    private int findSlotNumber(String key) {
        return Math.abs(key.hashCode()) % this.slots.length;
    }

    public T getValue(String key) {
        int slot = findSlotNumber(key);
        LinkedList<Node<T>> bucket = slots[slot];

        for (Node<T> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public Node<T> findNode(String key) {
        int slot = findSlotNumber(key);
        LinkedList<Node<T>> bucket = slots[slot];

        for (Node<T> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry;
            }
        }
        return null;
    }

    public boolean remove(String key) {
        int slot = findSlotNumber(key);
        LinkedList<Node<T>> bucket = slots[slot];

        Iterator<Node<T>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Node<T> entry = iterator.next();
            if (entry.getKey().equals(key)) {
                iterator.remove();
                elementsCount--;
                return true;
            }
        }
        return false;
    }

    public Iterable<String> keys() {
        LinkedList<String> keys = new LinkedList<>();
        for (LinkedList<Node<T>> bucket : slots) {
            for (Node<T> entry : bucket) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    public Iterable<T> values() {
        LinkedList<T> values = new LinkedList<>();
        for (LinkedList<Node<T>> bucket : slots) {
            for (Node<T> entry : bucket) {
                values.add(entry.getValue());
            }
        }
        return values;
    }

    @Override
    public Iterator<Node<T>> iterator() {
        LinkedList<Node<T>> allEntries = new LinkedList<>();
        for (LinkedList<Node<T>> bucket : slots) {
            allEntries.addAll(bucket);
        }
        return allEntries.iterator();
    }
}