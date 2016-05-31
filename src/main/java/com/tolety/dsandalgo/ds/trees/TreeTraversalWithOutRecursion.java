package com.tolety.dsandalgo.ds.trees;

import java.util.Stack;

/*
Using Stack is the obvious way to traverse tree without recursion.
Below is an algorithm for traversing binary tree using stack. See
this for step wise step execution of the algorithm.

1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.
 */
public class TreeTraversalWithOutRecursion {

    public void traverseTreeWithOutRecursion(Node root) {
       Node current = root;
       Stack<Node> stack = new Stack<Node>();

        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        while (stack.size() > 0) {
            current = stack.pop();
            System.out.print(current.key + " ");
            if (current.right != null) {
                current = current.right;
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        TreeTraversalWithOutRecursion tt = new TreeTraversalWithOutRecursion();
        tt.traverseTreeWithOutRecursion(root);
    }
}
