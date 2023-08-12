package Main;

import java.util.Scanner;

import LinkedList.*;
import Tree.*;

public class Main {
    public static void main(String[] args){
        Tree<String> tree = new Tree<>("root");

        Node<String> root = tree.getRoot();
        root.setChildren(new SinglyLinkedList<String>());

        Node<String> actualDir = root;        

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("> ");
            String command = sc.nextLine();
            String[] commandArray = command.split(" ");
            if (commandArray[0].equals("exit")) break;

            if (commandArray[0].equals("mkdir") && commandArray.length > 1 && actualDir.getChildren().searchNode(commandArray[1]) == null) tree.insertToTree(commandArray[1], actualDir);

            if (commandArray[0].equals("ls")) actualDir.getChildren().printList();

            if (commandArray[0].equals("tree")) tree.printTree(root, "");

            if (commandArray[0].equals("rmdir") && commandArray.length > 1) {
                actualDir.getChildren().delete(commandArray[0]);
            } 

            if (commandArray[0].equals("cd") && commandArray.length > 1) {
                if (commandArray[1].equals("..")) {
                    if (actualDir.getParent() != null) actualDir = actualDir.getParent();
                    else System.out.println("No se puede retroceder más");
                    continue;
                }
                Node<String> result = actualDir.getChildren().searchNode(commandArray[1]);
                if (result != null) actualDir = result;
                else System.out.println("No se encontró el directorio");
            }
        }
        sc.close();
    }
}
