package Tree;

import LinkedList.*;

public class Tree <T>{

    private Node<T> root;
    private int size = 0;

    public Tree(T t){ 
        this.root = new Node<T>(t);
        size++;
    }

    public Tree(Node<T> root){ this.root = root; }

    // Getter methods

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public Node<T> getRoot() { return root; }

    public void setRoot(Node<T> root) { this.root = root; }

    public void insertToTree(T t, Node<T> parent){
        Node<T> node = new Node<T>(t, null, parent);
        parent.getChildren().addLast(node);
        size++;
    }

    public void insertToTree(T t){
        insertToTree(t, root);
    }

    // * Los metodos de busqueda en el arbol son recursivos
    // * El método de impresion y de busqueda usan una lógica parecida


    public Node<T> searchInTree(T t, Node<T> root){
        if (root == null) return null;
        if (root.getChildren() == null) return null;
        Node<T> current = root.getChildren().first();  
        while (current != null){
            if (current.getElement().equals(t)) return current;
            Node<T> result = searchInTree(t, current);
            if (result != null) return result;
            current = current.getNext();
        }
        return null;
    }

    public Node<T> searchInTree(T t){
        return searchInTree(t, root);
    }

    public void printTree(Node<T> node, String tab){
        if (node == null) return;
        System.out.println(tab + node.getElement());
        if (node.getChildren() == null) return;
        Node<T> current = node.getChildren().first();
        while (current != null){
            printTree(current, tab + "\t");
            current = current.getNext();
        }
    }

    public void printTree(Node<T> node){
        printTree(node, "");
    }

    public void printTree(){
        printTree(root);
    }
}
