package com.tolety.dsandalgo.ds.linkedlist;

public class MergeSortDoubleLinkedList {

    public Node merge(Node first, Node second) {
        if (first == null) {
            return second;
        }
        else if (second == null) {
            return first;
        }
         else {
            if (first.data <= second.data) {
                first.next = merge(first.next,second);
                first.next.prev = first;
                first.prev = null;
                return first;
            }
            else {
                second.next= merge(first,second.next);
                second.next.prev = second;
                second.prev = null;
                return second;
            }
        }
    }

    public Node split (Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }

    public Node mergeSort (Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node second = split(head);
        head = mergeSort(head);
        second = mergeSort(second);
        return merge(head,second);
    }

    public static void main(String args[]) {
        Node head = new Node(7);
        head.next = new Node(4);
        head.next.prev = head;
        head.next.next = new Node(11);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(5);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(19);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        Node.printList(head);
        MergeSortDoubleLinkedList mergeSortDoubleLinkedList = new MergeSortDoubleLinkedList();
        head = mergeSortDoubleLinkedList.mergeSort(head);
        Node.printList(head);
    }
}
