package com.tolety.dsandalgo.ds.linkedlist;

/*
    Given a linked list as below with a loop. Detect it and remove it.

    Input linked list as below. 1 -> 2 -> 3 -> 4 -> 5 -> 2
              5 <- 4
              |    ^
              v    |
         1 -> 2 -> 3
    The output linked list must be 1 -> 2 -> 3 ->4 -> 5

    Distance traveled by fast pointer = 2 * (Distance traveled  by slow pointer)
    (m + n*x + k) = 2*(m + n*y + k)
    m --> Distance of first node of the cycle from head.
    n - > Length of cycle
    k --> Distance of point where slow meets head from the first node of the cycle.
    Note that before meeting the point shown above, fast was moving at twice speed.
    x -->  Number of complete cyclic rounds made by fast pointer before they meet first time
    y -->  Number of complete cyclic rounds made by  slow pointer before they meet first time
    From above equation, we can conclude below
     m + k = (x-2y)*n
    Which means m+k is a multiple of n.

    Floyd’s Cycle detection algorithm terminates when fast and slow pointers meet at a common point.
*/
public class DetectAndRemoveLoop {

    public void fixNodes(Node head){
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast!= null && fast.next != null ) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) {
            slow = head;
            Node endOfLoop = null;
            while (slow != fast) {
                slow = slow.next;
                endOfLoop= fast;
                fast = fast.next;
            }
            endOfLoop.next = null;
        }
    }

    public static void main(String args[]) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = head.next;

        DetectAndRemoveLoop detectAndRemoveLoop = new DetectAndRemoveLoop();
        detectAndRemoveLoop.fixNodes(head);
        Node.printList(head);
    }
}
