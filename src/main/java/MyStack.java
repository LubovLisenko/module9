import java.util.Arrays;

public class MyStack <T> {
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


    public void remove(int index) {
        if (currentLength < index) {
            return;
        }
        if (--currentLength > index) {
            System.arraycopy(array, index + 1, array, index, currentLength - index);
        }
        array[currentLength] = null;

    }

    public void clear() {
        array = new Object[capacity];
        currentLength = 0;

    }

    public int size() {
        return currentLength;
    }

    public T peek() {
        return (T) array[currentLength - 1];

    }

    public T pop() {
        T result = (T) array[currentLength - 1];
        array[--currentLength] = null;
        return result;

    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("name");
        myStack.push("name1");
        myStack.push("name2");
        System.out.println("myStack.peek() = " + myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push("name3");
        myStack.push("name4");
        myStack.push("name5");
        myStack.push("name6");
        myStack.push("name7");
        myStack.push("name8");
        myStack.push("name9");
        myStack.remove(6);
        System.out.println(myStack);
        System.out.println("myStack.size() = " + myStack.size());
        myStack.clear();
        System.out.println(myStack);
    }
}