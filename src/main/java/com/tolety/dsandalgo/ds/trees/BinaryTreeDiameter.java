package com.tolety.dsandalgo.ds.trees;

/*
Diameter of a Binary Tree
The diameter of a tree (sometimes called the width) is the number of nodes
on the longest path between two leaves in the tree. The diagram below shows
two trees each with diameter nine, the leaves that form the ends of a longest
path are shaded (note that there is more than one path in each tree of length
nine, but no path longer than nine nodes).

The diameter of a tree T is the largest of the following quantities:

* the diameter of T’s left subtree
* the diameter of T’s right subtree
* the longest path between leaves that goes through the root of T
      (this can be computed from the heights of the subtrees of T)
 */
public class BinaryTreeDiameter {

    // Compute hight of tree -- the number of nodes
    // along the longest path from the root node to
    // the farthest leaf node.
    public int heightOfTree(Node node) {
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

    public int max(int height, int ld, int rd) {
        if (height >= ld && height >= rd) {
           return height;
        }
        else if (ld >= height && ld >= rd) {
            return ld;
        }
        else if (rd >= height && rd >= ld) {
            return rd;
        }
        else {
            return 0;
        }
    }

    public int calculateDiameter(Node root)  {
        int lh = 0; // height of left tree
        int rh = 0; // height of right tree
        int ld = 0; // diameter of left tree
        int rd = 0; // diameter of right tree

        if (root == null) {
            return 0;
        } else {
            lh = heightOfTree(root.left);
            rh = heightOfTree(root.right);
            ld = calculateDiameter(root.left);
            rd = calculateDiameter(root.right);
            int height = lh + rh + 1;
            return max(height, ld, rd);
        }
    }

    public static void main(String args[]) {
       BinaryTreeDiameter binaryTree = new BinaryTreeDiameter();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        int diameter = binaryTree.calculateDiameter(root);
        System.out.println("Diameter of tree : " + diameter);
    }
}
