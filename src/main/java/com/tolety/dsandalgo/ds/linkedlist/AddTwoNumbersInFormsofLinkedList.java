package com.tolety.dsandalgo.ds.linkedlist;

/*
    Given two numbers represented by two lists, write a function that returns sum list.
    The sum list is list representation of addition of two input numbers.

    Input:
      First List: 5->6->3  // represents number 365
      Second List: 8->4->2 //  represents number 248
    Output
      Resultant list: 3->1->6  // represents number 613
*/
public class AddTwoNumbersInFormsofLinkedList {

    public Node addTwoList(Node head1, Node head2) {
        Node result = null;
        Node current = null;
        int carry = 0, sum = 0;

        // Atleast one linked list still exists.
        while (head1 != null || head2 != null) {
            // Calculate the next digit in the resultant list.
            // The next digit is the sum of the following three.
            // 1. carry
            // 2. next digit of head1
            // 3. next digit of head2
            sum = carry + (head1 != null ? head1.data : 0) + (head2 != null ? head2.data : 0);

            // update carry
            carry = sum / 10;

            // update sum
            sum = sum % 10;

            if (result == null) {
                result = new Node(sum);
                current = result;
            }
            else {
                current.next = new Node(sum);
                current = current.next;
            }
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.next = new Node(6);
        head1.next.next = new Node(3);

        Node head2 = new Node(8);
        head2.next = new Node(4);
        head2.next.next = new Node(2);

        AddTwoNumbersInFormsofLinkedList add = new AddTwoNumbersInFormsofLinkedList();

        Node.printList(head1);
        Node.printList(head2);
        Node result =  add.addTwoList(head1, head2);
        Node.printList(result);

    }
}
