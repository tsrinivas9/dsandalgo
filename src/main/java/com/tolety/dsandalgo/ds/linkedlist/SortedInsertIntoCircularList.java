package com.tolety.dsandalgo.ds.linkedlist;

public class SortedInsertIntoCircularList {

    public void insertIntoCircularList(Node head, int value) {
        Node current = head;
        Node last = null;
        while (current.next != head) {
            current = current.next;
        }
        last = current;
        // reset current;
        current = head;
        Node nodeToInsert = new Node(value);
        if (current.data > value) {
            nodeToInsert.next = current;
            last.next = nodeToInsert;
            head = nodeToInsert;
        }
        else if (last.data <= value) {
            nodeToInsert.next = head;
            last.next = nodeToInsert;
        }
        else {
            while (current.next != head) {
                if (current.data <= value && current.next.data > value) {
                    nodeToInsert.next = current.next;
                    current.next = nodeToInsert;
                    break;
                }
                current = current.next;
            }
        }
        Node.printCircularList(head);
    }

    public static void main(String args[]) {
        Node node = new Node(2);
        node.next = new Node(5);
        node.next.next = new Node(8);
        node.next.next.next = new Node(10);
        node.next.next.next.next= node;
        SortedInsertIntoCircularList sortedInsertIntoCircularList = new SortedInsertIntoCircularList();
        sortedInsertIntoCircularList.insertIntoCircularList(node, 7);
        sortedInsertIntoCircularList.insertIntoCircularList(node, 11);
        sortedInsertIntoCircularList.insertIntoCircularList(node, 1);
    }
}
