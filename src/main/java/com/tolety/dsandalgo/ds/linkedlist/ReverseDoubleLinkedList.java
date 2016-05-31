package com.tolety.dsandalgo.ds.linkedlist;

public class ReverseDoubleLinkedList {

    public Node reverse(Node head) {
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            head = current;
            current = temp;
        }
        return head;
    }


    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;
        Node.printList(head);
        ReverseDoubleLinkedList reverseDoubleLinkedList = new ReverseDoubleLinkedList();
        head = reverseDoubleLinkedList.reverse(head);
        Node.printList(head);
    }
}
