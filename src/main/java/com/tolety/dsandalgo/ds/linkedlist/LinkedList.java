package com.tolety.dsandalgo.ds.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedList {

    // LinkedList Node class (Inner class).
    // Made it static as I should be able to instantiate it in main.
    static class Node {
        int data;
        Node next;
        public Node (int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    // constructor
    public LinkedList() {

    }

    // Create linked list
    public void create(List<Integer> list) {
        Node current = null;
        for (Integer value : list ) {
            if (head == null) {
                head = new Node(value);
                current = head;
            }
            else {
                current.next = new Node(value);
                current = current.next;
            }
        }
    }

    // printList the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    // insert at the beginning of the linked list
    public void push(Node newNode) {
        newNode.next = head;
        head = newNode;
    }

    // insert after a given node in the linked list
    public void insertAfterANode (Node previousNode, Node newNode) {
        if (previousNode != null && newNode != null) {
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }
    }

    // Find node by index else return null
    public Node findNodeByIndex(int index) {
        int count = 0;
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (index == count) {
                // If index matches, we found the node with the index.
                found = true;
                break;
            }
            current = current.next;
            count++;
        }
        if (found) {
            return current;
        } else {
            return null;
        }
    }

    // Append a node to the linked list
    public void appendNode (Node newNode) {
        if (newNode != null) {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /* Given a key, deletes the first occurrence of key in linked list */
    public void deleteNodeByValue(int value) {
        Node current = head;
        Node prev = null;
        // If head node itself holds the key to be deleted.
        if (current != null && current.data == value ) {
            head = current.next;  // change head
        }
        else {
            prev = current;
            current = current.next;

            // Search for the key to be deleted, keep track of the
            // previous node as we need to change temp.next
            while (current != null && current.data != value) {
                prev = current;
                current = current.next;

            }

            if (current != null) {
                // Unlink the node from linked list
                prev.next = current.next;
            }
            else {
                // data is not present in the linked list.
            }
        }
    }

    public void deleteNodeByPostion(int position) {

        if (position == 0) {
            head = head.next;
        }

        int count = 1;
        Node current = head.next;
        Node prev = head;

        while (current != null) {
            if (count++ == position) {
                prev.next = current.next;
                break;
            }
            else {
                prev = current;
                current = current.next;
            }
        }

    }

    public int findCount() {
        int count = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public int getCount(Node current) {
        if (current == null) {
            return 0;
        }
        else {
            return 1 + getCount(current.next);
        }
    }

    public int findCountReccursive() {
        return getCount(head);
    }

    public void swapNodes (int x, int y) {
        // Nothing to do if x and y are same.
        if ( x == y) return;

        Node prevX = null;
        Node currentX = head;

        // First search for node with data x.
        // While doing keep track of previous node.
        while (currentX != null && currentX.data != x) {
            prevX = currentX;
            currentX = currentX.next;
        }

        Node prevY = null;
        Node currentY = head;

        // Second search for node with data y.
        // While doing keep track of previous node.
        while (currentY != null && currentY.data != y) {
            prevY = currentY;
            currentY = currentY.next;
        }

        // If either x or y is not present, nothing to do.
        if (currentX == null || currentY == null)
            return;

        // check if currentX is not head.
        if (prevX != null) {
            prevX.next = currentY;
        }
        else {
            head = currentY;
        }

        // Check if currentY is not head.
        if (prevY != null) {
            prevY.next = currentX;
        }
        else {
            head = currentX;
        }

        // Swap next nodes.
        Node temp = null;
        temp = currentX.next;
        currentX.next = currentY.next;
        currentY.next = temp;
    }


    public Node iterativeReverse(Node head) {

        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static void main (String args[]) {

        Random randomGenerator = new Random();
        List<Integer> list = new ArrayList<Integer>();
        for (int idx = 1; idx <= 10; ++idx){
            int randomInt = randomGenerator.nextInt(100);
            list.add(randomInt);
        }
        System.out.println(list);
        LinkedList linkedList = new LinkedList();
        linkedList.create(list);
        linkedList.printList();

        System.out.println("===== Add new head");
        Node newHead = new Node(125);
        linkedList.push(newHead);
        linkedList.printList();

        System.out.println("==== Find sixth node. Add between sixth and seventh");
        Node node = linkedList.findNodeByIndex(6);
        Node newSeventh = new Node(135);
        linkedList.insertAfterANode(node, newSeventh);
        linkedList.printList();

        System.out.println("==== Append a node.");
        Node appendNode = new Node(145);
        linkedList.appendNode(appendNode);
        linkedList.printList();

        System.out.println("==== Unlink the node with the data of 125");
        linkedList.deleteNodeByValue(125);
        linkedList.printList();

        System.out.println("==== Unlink the node with the data of 135");
        linkedList.deleteNodeByValue(135);
        linkedList.printList();

        System.out.println("==== Unlink the node with position 3");
        linkedList.deleteNodeByPostion(3);
        linkedList.printList();

        System.out.println("==== Unlink the node with position 15");
        linkedList.deleteNodeByPostion(15);
        linkedList.printList();

        System.out.println("==== find count of the linked list = " + linkedList.findCount());
        System.out.println("==== find count of the linked list = " + linkedList.findCountReccursive());

        System.out.println("==== Find sixth node. Add between sixth and seventh");
        node = linkedList.findNodeByIndex(2);
        newSeventh = new Node(135);
        linkedList.insertAfterANode(node, newSeventh);
        linkedList.printList();

        linkedList.swapNodes(135, 145);
        linkedList.printList();

        linkedList.push(new Node(110));
        linkedList.printList();
        linkedList.swapNodes(110,135);
        linkedList.printList();

        linkedList.head = linkedList.iterativeReverse(linkedList.head);
        linkedList.printList();
    }
}
