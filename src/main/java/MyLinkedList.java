import java.util.LinkedList;
import java.util.Objects;

public class MyLinkedList <T> {
  static class Node<T> {
    T element;
    Node<T> next;

    public Node(T element) {
      this.element = element;
    }
  }
  private Node<T> first;

  private Node<T>  last;
  private int size;

    public void add(T element) {
      Node<T> objectNode = new Node<>(element);
      if (first == null) {
        first = last = objectNode;
      } else {
        this.last.next = objectNode;
        last = objectNode;
      }
      size++;
    }

    public int size (){
      return size;
    }
  public T remove(int index){
      Objects.checkIndex(index, size);
      T removeElement;
      if (index == 0){
          removeElement = first.element;
          first = first.next;
      }
      if (index == size){
          removeElement = last.element;
          last = null;
      }
      Node <T>  prev = getNodeByIndex (index - 1);
      removeElement = prev.element;
      prev.next = prev.next.next;

      Node<T> current = first;
      for (int i = 1; i <= index -1; i++) {
          current = current.next;
      }
      removeElement = current.element;


      size--;
      return removeElement;
  }
  public  void  clear(){
        first = last = null;
        size = 0;
  }

  private Node <T> getNodeByIndex (int index) {
      Node<T> current = first;
      for (int i = 0; i <= index - 1; i++) {
          current = current.next;
      }
      return current;
  }

    public T get(int index){
        Objects.checkIndex(index,size);
      Node<T> current = first;
      for (int i = 0; i <= index -1; i++){
        current = current.next;
      }

        return current.element;
    }

   public void print() {
       Node<T> current = first;
       while (current != null) {
           System.out.println("current.element = " + current.element);
           current = current.next;

       }
   }

      public static void main (String[]args) {
          MyLinkedList<String> myLinkedList = new MyLinkedList<>();
          myLinkedList.add("name0");
          myLinkedList.add("name1");
          myLinkedList.add("name2");
          myLinkedList.add("name3");
          myLinkedList.add("name4");
          myLinkedList.add("name5");
          myLinkedList.add("name6");
          myLinkedList.print();
          System.out.println("myLinkedList.get() = " + myLinkedList.get(2));
          System.out.println("myLinkedList.size = " + myLinkedList.size());
          System.out.println("myLinkedList.remove() = " + myLinkedList.remove(4));
          myLinkedList.print();
          // myLinkedList.clear();
          System.out.println("myLinkedList.size = " + myLinkedList.size());
          }
      }

