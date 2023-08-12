package LinkedList;

public class Node<T> {
    
    private T element;
    private Node<T> next;
    private Node<T> parent;
    private SinglyLinkedList<T> children;

    public Node(T t, Node<T> n, Node<T> p, SinglyLinkedList<T> children){
        this.element = t;
        this.next = n;
        this.parent = p;
        this.children = children;
    }

    public Node(T t, Node<T> n, Node<T> p){
        this.element = t;
        this.next = n;
        this.parent = p;
        this.children = new SinglyLinkedList<T>();
    }

    public Node(T t, Node<T> n, SinglyLinkedList<T> children){
        this.element = t;
        this.next = n;
        this.children = children;
        this.parent = null;
    }

    public Node(T t, Node<T> n){
        this.element = t;
        this.next = n;
        this.children = new SinglyLinkedList<T>();
        this.parent = null;
    }

    public Node(T t){
        this.element = t;
        this.next = null;
        this.children = new SinglyLinkedList<T>();
        this.parent = null;
    }

    public T getElement(){ return this.element; }

    public Node<T> getNext(){ return this.next; }

    public void setNext(Node<T> n){ this.next = n; }

    public SinglyLinkedList<T> getChildren(){ return this.children; }

    public void setChildren(SinglyLinkedList<T> children){ this.children = children; }

    public Node<T> getParent(){ return this.parent; }
    
    public String toString(){
        return this.element.toString();
    }
}
