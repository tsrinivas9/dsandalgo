package com.tolety.dsandalgo.ds.trees;

/*
Check if a binary tree is subtree of another binary tree
Given two binary trees, check if the first tree is subtree
of the second one. A subtree of a tree T is a tree S
consisting of a node in T and all of its descendants in T.
The subtree corresponding to the root node is the entire tree;
the subtree corresponding to any other node is called a proper subtree.

For example, in the following case, tree S is a subtree of tree T.

        Tree 2
          10
        /    \
      4       6
       \
        30


        Tree 1
              26
            /   \
          10     3
        /    \     \
      4       6      3
       \
        30
Solution: Traverse the tree T in preorder fashion. For every
visited node in the traversal, see if the subtree rooted
with this node is identical to S.
 */
public class CheckForSubTree {

    public boolean areTreesIdenttical(Node tree1, Node tree2) {
       if (tree1 == null && tree2 == null) {
           return true;
       }
        else if (tree1 == null && tree2 != null) {
           return false;
       }
        else if (tree1 != null && tree2 == null) {
           return false;
       }
        else {
          return (tree1.key == tree2.key
                  && areTreesIdenttical(tree1.left, tree2.left)
                    && areTreesIdenttical(tree1.right, tree2.right));
       }
    }

    public boolean isSubTree(Node tree1, Node tree2) {

        if (tree1 == null && tree2 == null) {
            return true;
        }
        else if (tree1 == null && tree2 != null) {
            return false;
        }
        else if (tree1 != null && tree2 == null) {
            return false;
        }
        else {
            if (areTreesIdenttical(tree1,tree2))
                return true;
            else {
                return (isSubTree(tree1.left, tree2) || isSubTree(tree1.right, tree2));
            }
        }
    }

    public static void main(String args[]) {
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        Node root1 = new Node(26);
        root1.right = new Node(3);
        root1.right.right = new Node(3);
        root1.left = new Node(10);
        root1.left.left = new Node(4);
        root1.left.left.right = new Node(30);
        root1.left.right = new Node(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        Node root2 = new Node(10);
        root2.right = new Node(6);
        root2.left = new Node(4);
        root2.left.right = new Node(30);

        CheckForSubTree subTree = new CheckForSubTree();
        if (subTree.isSubTree(root1, root2)) {
            System.out.println("Tree 2 is subtree of Tree 1 ");
        } else {
            System.out.println("Tree 2 is not a subtree of Tree 1");
        }
    }
}
