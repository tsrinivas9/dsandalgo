package com.tolety.dsandalgo.ds.linkedlist;

public class MergeTwoSortedLists {

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

    public static void main(String args[]) {

        Node one = new Node(1);
        one.next = new Node(3);
        one.next.next = new Node(7);
        one.next.next.next = new Node(11);

        Node two = new Node(2);
        two.next = new Node(5);
        two.next.next = new Node(10);
        two.next.next.next = new Node(14);
        two.next.next.next.next = new Node(18);
        MergeTwoSortedLists merge = new MergeTwoSortedLists();
        Node result = merge.mergeSortedList(one,two);
        Node.printList(result);
    }
}
