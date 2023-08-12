package LinkedList;

public class SinglyLinkedList<T> {
    
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public SinglyLinkedList(){}

    // Getter methods

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public Node<T> first() { return head; }
    public Node<T> last() { return tail; }

    // Update methods

    public void addFirst(T t){
        head = new Node<>(t, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T t, Node<T> parent){
        Node<T> newest = new Node<>(t, null, parent);
        if (isEmpty())
            head = newest;
         else 
            tail.setNext(newest);
        size++;
    }

    public void addLast(Node<T> current){
        if (isEmpty())
            head = current;
         else 
            tail.setNext(current);
        tail = current;
        size++;
    }

    public void addLast(T t){
        Node<T> newest = new Node<>(t);
        if (isEmpty())
            head = newest;
         else 
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    public T removeFirst(){
        if (isEmpty()) return null;
        T answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)                                                                  
            tail = null;

        return answer;
    }

    public Node<T> searchNode(T t){
        Node<T> current = head;
        while (current != null){
            if (current.getElement().equals(t)) return current;
            current = current.getNext();
        }
        return null;
    }

    public Node<T> searchNodePosition(int i){
        Node<T> current = head;
        if (i>size) { return null;}
        for (int j=0; j<i; j++){
            current = current.getNext();
        }
        return current;
    }

    public void printList(){
        Node<T> current = head;
        while (current != null){
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

    public void delete(T t){
        // ! Add logic to erase here
    }

}
