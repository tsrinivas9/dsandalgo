package com.tolety.dsandalgo.ds.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Construct Tree from given Inorder and Preorder traversals
Let us consider the below traversals:

Inorder sequence: D B E A F C
Preorder sequence: A B D E C F

In a Preorder sequence, leftmost element is the root of the tree. So we know ‘A’ is root for given sequences. By searching ‘A’ in Inorder sequence, we can find out all elements on left side of ‘A’ are in left subtree and elements on right are in right subtree. So we know below structure now.

                 A
               /   \
             /       \
           D B E     F C
We recursively follow above steps and get the following tree.

         A
       /   \
     /       \
    B         C
   / \        /
 /     \    /
D       E  F
Algorithm: buildTree()
1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call.
2) Create a new tree node tNode with the data as picked element.
3) Find the picked element’s index in Inorder. Let the index be inIndex.
4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
6) return tNode.
*/
public class ConstructTreeFromInOrderAndPreOrderTraversals {

    public int findIndexInInorder(List<Integer> inOrder, int start, int end, int value) {
        int ret = -1;

        for (int i = start; i <= end; i++) {
            if (inOrder.get(i) == value) {
                ret = i;
                break;
            }
        }
        return ret;
    }

    public Node buildBinaryTree(List<Integer> inOrder, List<Integer> preOrder, int start, int end, int idx) {
        Node node = null;

        // Pick current Node from preOrder traversal
        node = new Node(preOrder.get(idx++));
        if (start == end) {
            return node;
        }
        int indexInInorder = findIndexInInorder(inOrder,start, end, node.key);
        if (indexInInorder == -1) {
            return null;
        }

        node.left = buildBinaryTree(inOrder, preOrder, start, indexInInorder - 1, idx);
        node.right = buildBinaryTree(inOrder,preOrder, indexInInorder + 1, end, idx);
        return node;
    }

    public static void main(String args[]) {
        List<Integer> inOrder = new ArrayList<Integer>(Arrays.asList( 4, 2, 5, 1, 6, 3));
        List<Integer> preOrder = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5, 3, 6));
        ConstructTreeFromInOrderAndPreOrderTraversals construct = new ConstructTreeFromInOrderAndPreOrderTraversals();
        Node tree = construct.buildBinaryTree(inOrder, preOrder, 0, preOrder.size() -1, 0);
        Node.printInorder(tree);
    }
}
