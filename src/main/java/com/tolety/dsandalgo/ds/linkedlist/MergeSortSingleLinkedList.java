package com.tolety.dsandalgo.ds.linkedlist;

public class MergeSortSingleLinkedList {

    Node mergeSortedList(Node one, Node two) {
        Node result = null;
        Node current = null;
        Node nodeToAdd = null;
        while (one != null || two!= null) {
            if (one != null && two != null) {
                if (one.data < two.data) {
                    nodeToAdd = one;
                    one = one.next;
                }
                else {
                    nodeToAdd = two;
                    two = two.next;
                }
            }
            else if ( one == null && two != null) {
                nodeToAdd = two;
                two = two.next;
            }
            else if (one != null && two == null) {
                nodeToAdd = one;
                one = one.next;
            }
            else {
                // both lists are null.
                break;
            }
            if (result == null) {
                result = nodeToAdd;
                current = result;
            }
            else {
                current.next = nodeToAdd;
                current = current.next;
            }
        }
        current.next = null;
        return result;
    }

    public Node mergeSort(Node input) {
        Node firstList = null;
        Node secondList = null;

        // length <= 2
        if (input != null && ( input.next == null || input.next.next == null)) {
            firstList = input;
            secondList = input.next;
            firstList.next = null;
        }
        else {
            Node slow = input;
            Node fast = input.next;

            // Advance 'fast' two nodes while advance 'slow' by one node
            while (fast != null) {
                fast = fast.next;
                if (fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }

            // 'slow' is before the midpoint in the list, so split it into two at that point
            firstList = input;
            secondList = slow.next;
            slow.next = null;
            firstList = mergeSort(firstList);
            secondList = mergeSort(secondList);
        }
        input = mergeSortedList(firstList,secondList);
        return input;
    }

    public static void main(String[] args) {
        Node node = new Node(14);
        node.next = new Node(11);
        node.next.next = new Node(15);
        node.next.next.next = new Node(7);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(16);
        node.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next = new Node(1);
        node.next.next.next.next.next.next.next.next = new Node(9);
        MergeSortSingleLinkedList sort = new MergeSortSingleLinkedList();
        Node result = sort.mergeSort(node);
        Node.printList(result);
    }
}
