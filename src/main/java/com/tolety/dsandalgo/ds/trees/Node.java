package com.tolety.dsandalgo.ds.trees;

public class Node {
    int key;
    Node left, right;
    public Node(int item) {
        key = item;
        left = null;
        right = null;
    }
    /* This funtcion is here just to test buildTree() */
    public static void printInorder(Node node) {
        if (node == null) {
            return;
        }

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }
}
