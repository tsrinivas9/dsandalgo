package com.tolety.dsandalgo.ds.linkedlist;

public class TraverseCircularLinkedList {

    public void traverseCircularList(Node head) {
        Node node = head;
        do {
            System.out.print(node.data + " ");
            node = node.next;
        } while (node != head);
        System.out.println("");
    }

    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(8);
        head.next.next.next.next.next = head;
        TraverseCircularLinkedList circularLinkedList = new TraverseCircularLinkedList();
        circularLinkedList.traverseCircularList(head);
    }
}
