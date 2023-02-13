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

    private int capacity = 16;
    private Node<K, V> [] buckets = new Node[capacity];

    private int size = 0;


    public void put(K key, V value) {
        if (size == capacity) {
            capacity = capacity * 2;
        }
        int index = Math.abs(key.hashCode() % capacity) ;
        Node<K, V> node = buckets[index];
        Node<K, V> newNode = new Node<>(key, value);

        if (node == null) {
            buckets[index] = newNode;
        } else {
            Node<K, V> prev = node;
            while (node != null) {
                if (key == null || node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = newNode;
        }
            size++;
        return;
//
//
//        int index = 0;//Math.abs(key.hashCode() % capacity);
//        Node <K,V> current= buckets[index];
//        if (current == null){
//            buckets[index] = new Node<>(key, value);
//            size++;
//        } else {
//            Node <K,V> prev = current;
//            while (prev != null){
//                if (current.key.equals(key)){
//                    current.value = value;
//                    return;
//                }
//                prev = prev.next;
//                if (prev.next == null){
//                    Node <K,V >newNode = new Node<>(key,value);
//                    prev.next = newNode;
//                    return;
//                }
//            }

//        }
    }


        public V remove (K key) {
            Node removeNode = buckets[Math.abs(key.hashCode() % capacity)];

            if (removeNode == null) {
                return null;
            }
            if (removeNode.key.equals(key)) {
                buckets[key.hashCode() % size] = removeNode.next;
                size--;
                return (V) removeNode.value;
            }

            if (removeNode.next == null) {
                return null;
            }

            if (removeNode.next.key.equals(key)) {
                Object returningNodeValue = removeNode.next.value;
                removeNode.next = removeNode.next.next;
                removeNode.next.next = null;
                return (V) returningNodeValue;
            }
            return (V) key;
        }
        public void clear () {
        capacity = 16;
            buckets = new Node[capacity];
            size = 0;
        }

        public int size () {
            return size;
        }

        public V get (K key){
            int index = Math.abs(key.hashCode() % capacity);
            return buckets[index].value;

        }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "capacity=" + capacity +
                ", buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                '}';
    }

    public static void main (String[]args){
            MyHashMap<String, Integer> myHashMap = new MyHashMap();
            myHashMap.put("name",  1);
            myHashMap.put("name1", 2);
            myHashMap.put("name2", 3);
            myHashMap.put("name3", 4);
            myHashMap.put("name3", 5);
            myHashMap.put("name",  6);
            myHashMap.put("name5", 7);
            myHashMap.put("name6", 8);
            myHashMap.put("name7", 9);
            myHashMap.put("name8", 10);
            myHashMap.put("name9", 11);
            myHashMap.put("name10",12);
                 System.out.println("myHashMap.size() = " + myHashMap.size());
                 System.out.println("myHashMap.get(\"name\") = " + myHashMap.get("name"));
                 System.out.println("myHashMap.remove() = " + myHashMap.remove("name"));
        // myHashMap.clear();

    }
    }
