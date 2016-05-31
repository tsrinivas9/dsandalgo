package com.tolety.dsandalgo.ds.trees;

/*
Unlike linear data structures (Array, Linked List, Queues, Stacks, etc)
which have only one logical way to traverse them, trees can be traversed
in different ways. Following are the generally used ways for traversing trees.


Depth First Traversals:
(a) Inorder
(b) Preorder
(c) Postorder

Breadth First or Level Order Traversal
Please see this post for Breadth First Traversal.

Inorder Traversal:

Algorithm Inorder(tree)
   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
Uses of Inorder
In case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order.
To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder
traversal s reversed, can be used.
Example: Inorder traversal for the above given figure is 4 2 5 1 3.

Preorder Traversal:

Algorithm Preorder(tree)
   1. Visit the root.
   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   3. Traverse the right subtree, i.e., call Preorder(right-subtree)
Uses of Preorder
Preorder traversal is used to create a copy of the tree. Preorder traversal is also used to
get prefix expression on of an expression tree. Please see http://en.wikipedia.org/wiki/Polish_notation
to know why prefix expressions are useful.
Example: Preorder traversal for the above given figure is 1 2 4 5 3.

Postorder Traversal:

Algorithm Postorder(tree)
   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   3. Visit the root.
Uses of Postorder
Postorder traversal is used to delete the tree. Please see the question for deletion of tree for details.
Postorder traversal is also useful to get the postfix expression of an expression tree.
Please see http://en.wikipedia.org/wiki/Reverse_Polish_notation to for the usage of postfix expression.

Example: Postorder traversal for the above given figure is 4 5 2 3 1.

 Level order traversal of a tree is breadth first traversal for the tree.

 Level order traversal of the above tree is 1 2 3 4 5

Algorithm:
There are basically two functions in this method. One is to print all nodes
at a given level (printGivenLevel), and other is to print level order traversal of
the tree (printLevelorder). printLevelorder makes use of printGivenLevel to print
nodes at all levels one by one starting from root.

Function to print level order traversal of tree

printLevelorder(tree)
        for d = 1 to height(tree)
        printGivenLevel(tree, d);

Function to print all nodes at a given level
        printGivenLevel(tree, level)
        if tree is NULL then return;
        if level is 1, then
        print(tree->data);
        else if level greater than 1, then
        printGivenLevel(tree->left, level-1);
        printGivenLevel(tree->right, level-1);

 */
public class BinaryTreeTraversal {

    Node root = null;

    // Given a binary tree, print its node according to the "bottom-up"
    // post order traversal
    private void printDepthFirstPostOrder(Node node) {
        if (node == null)
            return;

        // first call recursively on left node
        printDepthFirstPostOrder(node.left);

        // second call recursively on right node
        printDepthFirstPostOrder(node.right);

        // third print the current node
        System.out.print(node.key + " ");
    }

    public void printDepthFirstPostOrder() {
        System.out.print("Post order of binary tree : ");
        printDepthFirstPostOrder(root);
        System.out.println("");
    }

    // Given a binary tree, print its nodes in order
    private void printDepthFirstInOrder(Node node) {
        if (node == null) {
            return;
        }

        // first call recursively on left node
        printDepthFirstPostOrder(node.left);

        // second print current node.
        System.out.print(node.key + " ");

        // thrid call recursively on right node
        printDepthFirstPostOrder(node.right);
    }

    public void printDepthFirstInOrder() {
        System.out.print("Inorder of binary tree : ");
        printDepthFirstInOrder(root);
        System.out.println("");
    }

    // Give a binary tree, print its node in preorder
    private void printDepathFirstPreOrder(Node node) {

        if (node == null) {
            return;
        }

        // first print data of node
        System.out.print(node.key + " ");

        // second traverse recursively on left node
        printDepathFirstPreOrder(node.left);

        // third traverse recursively on right node
        printDepathFirstPreOrder(node.right);
    }

    public void printDepathFirstPreOrder() {
        System.out.print("Preorder of binary tree : ");
        printDepathFirstPreOrder(root);
        System.out.println("");
    }

    // Compute hight of tree -- the number of nodes
    // along the longest path from the root node to
    // the farthest leaf node.
    private int heightOfTree(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            int leftHeight = heightOfTree(node.left);
            int rightHeight = heightOfTree(node.right);
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            }
            else {
                return rightHeight + 1;
            }
        }
    }

    private void printGivenLevel(Node node, int height) {
        if (node == null) {
            return;
        }
        if (height == 1) {
            System.out.print(node.key + " ");
        }
        else if (height > 1) {
             printGivenLevel(node.left, height - 1);
             printGivenLevel(node.right, height - 1);
        }
    }

    public void printLevelOrder() {
        int height = heightOfTree(root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
        }
        System.out.println("");
    }

    public static void main(String args[]) {
       BinaryTreeTraversal binaryTree = new BinaryTreeTraversal();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.printDepthFirstPostOrder();
        binaryTree.printDepthFirstInOrder();
        binaryTree.printDepathFirstPreOrder();
        System.out.print("Level order traversal of binary tree :");
        binaryTree.printLevelOrder();
    }
}
