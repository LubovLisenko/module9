import java.util.Arrays;

public class MyQueue<T> { // add перевірити
    private int capacity = 5;
    public Object[] array = new Object[capacity];
    private int currentLength = 0;

    public void push(T value) {
        if (currentLength == array.length) {
            int newCapacity = currentLength * 2;
            Object[] tmp = new Object[newCapacity];
            System.arraycopy(array, 0, tmp, 0, currentLength);
            array = tmp;
        }
        array[currentLength] = value;
        currentLength++;
    }

    public void clear() {
        array = new Object[capacity];
        currentLength = 0;

    }

    public int size() {
        return currentLength;
    }

    public T peek() {
        return (T) array[0];

    }

    public T poll() {
        T result = (T) array[0];
        array[0] = null;
        for (int i = 0; i < currentLength - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--currentLength] = null;
        return result;

    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.push("name0");
        myQueue.push("name1");
        myQueue.push("name2");
        myQueue.push("name3");
        myQueue.push("name4");
        myQueue.push("name5");
        myQueue.push("name6");
        System.out.println("myQueue = " + myQueue);
        System.out.println("myQueue.peek() = " + myQueue.peek());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.size() = " + myQueue.size());
        System.out.println("myQueue = " + myQueue);
        myQueue.clear();
        System.out.println("myQueue = " + myQueue);
    }
}