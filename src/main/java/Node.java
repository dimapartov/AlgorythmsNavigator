public class Node<T> {

    private String key;
    private T value;

    public Node(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public T getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public void setValue(T value) {
        this.value = value;
    }
}