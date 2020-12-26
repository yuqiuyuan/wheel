package chapter1;

/**
 * HashMap
 *
 * @author drebander
 * @since 2020-12-26 5:24 下午
 **/
public class HashMap<K, V> {

    Node[] table;

    public void put(K key, V value) {
        // 1、判断是否需要初始化数组
        if (null == table) {
            table = new Node[16];
        }
        Node cur = table[key.hashCode() % table.length];
        if (null == cur) {
            Node node = new Node(key, value);
            table[key.hashCode() % table.length] = node;
        } else {
            //存在相同的key，进行更新操作
            while (cur.hashNext()) {
                if (key.equals(cur.getKey())) {
                    break;
                }
                cur = cur.getNext();
            }
            if (cur.hashNext()) {
                cur.setValue(value);
            } else {
                Node next = new Node(key, value);
                cur.setNext(next);
            }
        }
    }

    public V get(K key) {
        Node cur = table[key.hashCode() % table.length];
        while (null != cur) {
            if (cur.getKey().equals(key)) {
                return (V) cur.getValue();
            }
            cur = cur.getNext();
        }
        return null;
    }

}
