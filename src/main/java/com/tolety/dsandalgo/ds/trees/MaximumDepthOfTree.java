package com.tolety.dsandalgo.ds.trees;

/*
Write a Program to Find the Maximum Depth or Height of a Tree
Recursively calculate height of left and right subtrees of a
node and assign height to the node as max of the heights of
two children plus 1. See below pseudo code and program for details.

Algorithm:

 maxDepth()
1. If tree is empty then return 0
2. Else
     (a) Get the max depth of left subtree recursively  i.e.,
          call maxDepth( tree->left-subtree)
     (a) Get the max depth of right subtree recursively  i.e.,
          call maxDepth( tree->right-subtree)
     (c) Get the max of max depths of left and right
          subtrees and add 1 to it for the current node.
         max_depth = max(max dept of left subtree,
                             max depth of right subtree)
                             + 1
     (d) Return max_depth
*/

public class MaximumDepthOfTree {

    public int maximumDepth(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            int ldepth = maximumDepth(node.left);
            int rdepth = maximumDepth(node.right);
            if (ldepth > rdepth) {
                 return ldepth + 1;
            }
            else {
                return rdepth + 1;
            }
        }
    }

    public static void main(String args[]) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(11);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(13);
        MaximumDepthOfTree depth = new MaximumDepthOfTree();
        int value = depth.maximumDepth(root);
        System.out.println("depth = " + value);
    }
}
