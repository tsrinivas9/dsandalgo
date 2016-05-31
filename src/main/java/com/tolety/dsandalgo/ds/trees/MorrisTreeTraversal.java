package com.tolety.dsandalgo.ds.trees;

/*
Inorder Tree Traversal without recursion and without stack!
Using Morris Traversal, we can traverse the tree without using stack and recursion.
The idea of Morris Traversal is based on Threaded Binary Tree. In this traversal,
we first create links to Inorder successor and print the data using these links,
and finally revert the changes to restore original tree.

1. Initialize current as root
2. While current is not NULL
   If current does not have left child
      a) Print current’s data
      b) Go to the right, i.e., current = current->right
   Else
      a) Make current as right child of the rightmost node in current's left subtree
      b) Go to this left child, i.e., current = current->left
Although the tree is modified through the traversal, it is reverted back to its
original shape after the completion. Unlike Stack based traversal, no extra space
is required for this traversal.
 */
public class MorrisTreeTraversal {


    public void morrisTreeTraversal(Node root) {
       Node current = root;
        Node predecessor = null;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.key + " ");
                current = current.right;
            }
            else {
                // Find in-order predecessor of current.
                predecessor = current.left;
                while(predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // Make current as right child of its inorder predecessor
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }
                else {
                    // Revert the change made in "if part" above to restore
                    // the original tree i.e. fix the right child predecessor
                    predecessor.right = null;
                    System.out.print(current.key + " ");
                    current = current.right;
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
        MorrisTreeTraversal mtt = new MorrisTreeTraversal();
        mtt.morrisTreeTraversal(root);
    }
}
