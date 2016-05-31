package com.tolety.dsandalgo.ds.linkedlist;

/*
    Rotate a Linked List
    Given a singly linked list, rotate the linked list counter-clockwise by k nodes.
    Where k is a given positive integer. For example, if the given linked list is
    10->20->30->40->50->60 and k is 4, the list should be modified to 50->60->10->20->30->40.
    Assume that k is smaller than the count of nodes in linked list.
*/

public class RotateLinkedList {

    static class Node {
        int data;
        Node next;
        Node (int d){
            data = d;
            next = null;
        }
    }

    // printList the linked list
    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    public Node rotateLinkedListByK(Node head, int k) {
        Node kthNode = null;
        Node current = head;
        int count = 1;

        while (count < k && current != null) {
            current = current.next;
            count++;
        }
        kthNode = current;

        if (kthNode != null) {
            while (current.next != null) {
                current = current.next;
            }
            current.next = head;
            head = kthNode.next;
            kthNode.next = null;
        }
        return head;
    }

    public static void main(String args[]) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node (30);
        head.next.next.next = new Node (40);
        head.next.next.next.next = new Node (50);
        head.next.next.next.next.next = new Node(60);

        RotateLinkedList rotate = new RotateLinkedList();
        head = rotate.rotateLinkedListByK(head, 4);
        rotate.printList(head);
    }
}
