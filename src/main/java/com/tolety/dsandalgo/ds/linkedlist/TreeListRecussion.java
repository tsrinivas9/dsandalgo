package com.tolety.dsandalgo.ds.linkedlist;

/*
     --Recursion--
     Given an ordered binary tree, recursively change it into
     a circular doubly linked list which is returned.
*/
public class TreeListRecussion {

    public void join(Node a, Node b) {
        a.next = b;
        b.prev = a;
    }

    public Node appendList(Node a, Node b) {
        // if either is noull return the other;
        if (a == null) {
            return b;
        }
        else if (b == null) {
            return a;
        }
        else {
            Node aPrev = a.prev;
            Node bPrev = b.prev;
            join(aPrev, b);
            join(bPrev, a);
        }
        return a;
    }

    public Node treeToList(Node root) {
        if (root == null) {
            return null;
        }

        // recursively do the sub trees.
        Node prevList = treeToList(root.prev);
        Node nextList = treeToList(root.next);

        // Make the root node as a single list;
        root.prev = root;
        root.next = root;

        // join them in the correct order;
        Node result = appendList(prevList, root);
        result = appendList(result, nextList);
        return result;
    }

    public static void main(String args[]) {
        Node root = new Node(4);
        Node.treeInsert(root, 2);
        Node.treeInsert(root, 1);
        Node.treeInsert(root, 3);
        Node.treeInsert(root, 5);
        Node.printTree(root);
        System.out.println("");

        TreeListRecussion treeListRecussion = new TreeListRecussion();
        Node result = treeListRecussion.treeToList(root);
        Node.printCircularList(result);
    }
}
