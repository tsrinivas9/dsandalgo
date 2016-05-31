package com.tolety.dsandalgo.ds.stacks;

public class Node {

    public int data;
    public Node next;
    public Node prev;

    public Node(int d){
        data = d;
        next = null;
        prev = null;
    }

    // printList the linked list
    static public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    static public void printCircularList(Node head) {
        Node current = head;
        while (current.next != head) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(current.data);
    }

    static public void printTree (Node root) {
        if (root != null) {
            Node.printTree(root.prev);
            System.out.print(root.data + " ");
            Node.printTree(root.next);
        }
    }

    public static void treeInsert(Node root, int value) {
        if (root.data <= value ) {
            if (root.next != null) {
                treeInsert(root.next, value);
            }
            else {
                root.next = new Node(value);
            }
        }
        else {
            if (root.prev != null) {
                treeInsert(root.prev, value);
            }
            else {
                root.prev = new Node(value);
            }
        }
    }
}
