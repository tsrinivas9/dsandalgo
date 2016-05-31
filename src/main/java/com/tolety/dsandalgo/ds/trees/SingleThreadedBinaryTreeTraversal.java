package com.tolety.dsandalgo.ds.trees;

/*
Threaded Binary Tree
Inorder traversal of a Binary tree is either be done using recursion
or with the use of a auxiliary stack. The idea of threaded binary trees
is to make inorder traversal faster and do it without stack and without
recursion. A binary tree is made threaded by making all right child
pointers that would normally be NULL point to the inorder successor
of the node (if it exists).

There are two types of threaded binary trees.

Single Threaded: Where a NULL right pointers is made to point to the
inorder successor (if successor exists)
Double Threaded: Where both left and right NULL pointers are made to
point to inorder predecessor and inorder successor respectively. The
predecessor threads are useful for reverse inorder traversal and
postorder traversal.
The threads are also useful for fast accessing ancestors of a node.
 */
public class SingleThreadedBinaryTreeTraversal {

    public ThreadedNode leftMost(ThreadedNode node) {
        ThreadedNode current = node;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void TraverseSingleThreadedBinaryTree(ThreadedNode root) {
        ThreadedNode current = leftMost(root);

        while (current != null) {
            System.out.print(current.key + " ");
            if(current.rightThreaded) {
                current = current.right;
            }
            else {
                current = leftMost(current.right);
            }
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        ThreadedNode root = new ThreadedNode(6);
        root.left = new ThreadedNode(3);
        root.left.left = new ThreadedNode(1);
        root.left.left.rightThreaded = true;
        root.left.left.right = root.left;
        root.left.right = new ThreadedNode(5);
        root.left.right.rightThreaded = true;
        root.left.right.right = root;
        root.right = new ThreadedNode(8);
        root.right.left = new ThreadedNode(7);
        root.right.left.rightThreaded = true;
        root.right.left.right= root.right;
        root.right.right = new ThreadedNode(11);
        root.right.right.left = new ThreadedNode(9);
        root.right.right.left.rightThreaded = true;
        root.right.right.left.right = root.right.right;
        root.right.right.right = new ThreadedNode(13);
        SingleThreadedBinaryTreeTraversal stbtt = new SingleThreadedBinaryTreeTraversal();
        stbtt.TraverseSingleThreadedBinaryTree(root);
    }
}
