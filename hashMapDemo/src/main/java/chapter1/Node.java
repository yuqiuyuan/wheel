package chapter1;

/**
 * Node
 *
 * @author drebander
 * @since 2020-12-26 5:19 下午
 **/
public class Node<K, V> {

    private K key;
    private V value;
    private int hashCode;

    private Node next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    boolean hashNext() {
        return null != next;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
