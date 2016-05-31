package com.tolety.dsandalgo.ds.linkedlist;

public class SplitCircularListInToTwo {

    public void splitList(Node head) {
        Node slow = head;
        Node fast = head;

        Node list1, list2;

        if (head != null) {

            /* If there are odd nodes in the circular list then
                fast_ptr->next becomes head and for even nodes
                fast_ptr->next->next becomes head
            */
            while (fast.next != head && fast.next.next != head) {
                slow = slow.next;
                fast = fast.next.next;
            }

            /* If there are even elements in list then move fast_ptr */
            if (fast.next.next == head) {
                fast = fast.next;
            }

            list1 = head;
            list2 = slow.next;
            slow.next = head;
            fast.next = list2;
            Node.printCircularList(list1);
            Node.printCircularList(list2);
        }
    }

    public static void main(String args[]) {
        Node node = new Node(14);
        node.next = new Node(11);
        node.next.next = new Node(15);
        node.next.next.next = new Node(7);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(16);
        node.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next = new Node(1);
        node.next.next.next.next.next.next.next.next = new Node(9);
        node.next.next.next.next.next.next.next.next.next = node;
        SplitCircularListInToTwo splitCircularListInToTwo = new SplitCircularListInToTwo();
        splitCircularListInToTwo.splitList(node);
    }
}
