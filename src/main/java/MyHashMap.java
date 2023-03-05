import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class MyHashMap<K, V> {

    public static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

  //  private int capacity = 5;

    private static final int DEFAULT_CAPACITY = 5;
    private Node<K, V>[] buckets = new Node[DEFAULT_CAPACITY];

    private int size = 0;


    public void resizeMap() {
       int capacity = buckets.length *2;
        Node<K, V>[] oldBucket = Arrays.copyOf(buckets, buckets.length);
        buckets = new Node[capacity];
        for (Node<K, V> node : oldBucket) {
            while (node != null) {
                addItems(node.key, node.value);
                node = node.next;
            }
        }
    }

    public void put(K key, V value) {
        addItems(key, value);
        if (size >= buckets.length) {
            resizeMap();
        }
        size++;
    }
    public void addItems(K key, V value) {
        Node<K,V>newNode=new Node<>(key, value);
        int hashIndex = Math.abs(key.hashCode()) % buckets.length;
        if (buckets[hashIndex]==null){
            buckets[hashIndex]= newNode;
        }else{
            Node<K,V>prev=null;
            Node<K,V>current = buckets[hashIndex];
            while (current!=null){
                if (current.key.equals(key)){
                    current.value=value;
                    size--;
                    return;
                }
                prev=current;
                current=current.next;
                if (prev!=null){
                    prev.next=newNode;
                }
            }
        }
    }

    public void remove(K key) {
        int hashIndex = Math.abs(key.hashCode()) % buckets.length;
        Node removeNode = buckets[hashIndex];

        if (removeNode == null) {
            return;
        }
        while (removeNode != null){
            if (removeNode.key.equals(key)) {
                buckets[hashIndex] = removeNode.next;
                size--;
            }
            removeNode = removeNode.next;
        }
    }
    public void clear() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode() % buckets.length);
        Node node = buckets[index];

        if (node == null) {
            return null;
        }

        while (node != null){
            if (node.key.equals(key)) {
            return (V) node.value;

            }
            node = node.next;
        }
        return buckets[index].value;

    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "buckets=" + Arrays.toString(buckets) +
                '}';
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap();
        for (int i = 0; i < 20; i++) {
            myHashMap.put("name"+i,i);
        }
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("myHashMap.get(\"name\") = " + myHashMap.get("name"));
        myHashMap.remove("name2");
        System.out.println("myHashMap.get(\"name\") = " + myHashMap.get("name"));
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.clear();
    }
}
