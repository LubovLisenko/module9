import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

public class MyArrayList<T> {

    private int capacity = 5;
    public Object[] array = new Object[capacity];
    private int currentLength = 0;

    public void add(T item) {
        if (currentLength == array.length) {
            int newCapacity = currentLength * 2;
            Object[] tmp = new Object[newCapacity];
            System.arraycopy(array, 0, tmp, 0, currentLength);
            array = tmp;
        }
        array[currentLength] = item;
        currentLength++;
    }

    public int size() {
        return currentLength;
    }

    public void clear() {
        array = new Object[capacity];
        currentLength = 0;

    }

    public void remove(int index) {
        if (index == currentLength-1) {
            array[index] = null;

        } else if (index == 0){
            array = Arrays.copyOfRange(array,1,array.length + 1);
        } else {
           for (int i = 0; i < array.length -1; i++){
               if (i >= index){
                   array [i] = array [i + 1];
               }
           }

        }
        currentLength--;

    }

    public T get(int index) {
        if (index >= array.length) {
            return null;

        }
        return (T) array[index];

    }


    @Override
    public String toString() {
        return Arrays.toString(array);

    }

    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("name0");
        myArrayList.add("name1");
        myArrayList.add("name2");
        myArrayList.add("name3");
        myArrayList.add("name4");
        myArrayList.add("name5");
        myArrayList.add("name6");
        System.out.println(myArrayList);
        System.out.println("myArrayList.size() = " + myArrayList.size());
        myArrayList.remove(3);
        System.out.println("myArrayList.get() = " + myArrayList.get(9));
        System.out.println(myArrayList);
        System.out.println("myArrayList.size() = " + myArrayList.size());
        myArrayList.clear();

     
    }
}

