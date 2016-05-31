package com.tolety.dsandalgo.ds.trees;

import java.util.HashMap;
import java.util.Map;

public class CloneBinaryTreeWithRandomNodes {

    public static class NodeWithRandomNodes {

        int key;
        NodeWithRandomNodes left, right, random;

        public NodeWithRandomNodes(int value) {
            key = value;
            left = null;
            right = null;
            random = null;
        }
    }

    public void inOrderPrint(NodeWithRandomNodes node) {
        if (node == null)
            return;
        else {
            inOrderPrint(node.left);
            System.out.print(" key = " + node.key);
            if (node.random == null) {
                System.out.print(" random = " + null);
            }
            else {
                System.out.print(" random = " + node.random.key + ", ");
            }
            inOrderPrint(node.right);
        }
    }

    // This method creates clone by coping key and left and right pointers
    // This method also stores mapping from given tree node to clone.
    public NodeWithRandomNodes copyLeftToRightNode(NodeWithRandomNodes orgNode, Map<NodeWithRandomNodes,NodeWithRandomNodes> nodeMap) {
        if (orgNode == null) {
            return null;
        }
        else {
            NodeWithRandomNodes clonedNode = new NodeWithRandomNodes(orgNode.key);
            nodeMap.put(orgNode,clonedNode);
            clonedNode.left = copyLeftToRightNode(orgNode.left,nodeMap);
            clonedNode.right = copyLeftToRightNode(orgNode.right,nodeMap);
            return clonedNode;
        }
    }

    // The method will copy random nodes using the Map
    public void copyRandomNodes(NodeWithRandomNodes orgNode, NodeWithRandomNodes clonedNode, Map<NodeWithRandomNodes,NodeWithRandomNodes> nodeMap) {
        if (orgNode == null || clonedNode == null)
            return;
        clonedNode.random = nodeMap.get(orgNode.random);
        copyRandomNodes(orgNode.left,clonedNode.left,nodeMap);
        copyRandomNodes(orgNode.right,clonedNode.right, nodeMap);
    }

    // This method will make a copy of the given binary tree.
    public NodeWithRandomNodes copyBinaryTree(NodeWithRandomNodes orgNode) {
        if (orgNode == null)
            return null;
        else {
            Map<NodeWithRandomNodes, NodeWithRandomNodes> nodeMap = new HashMap<NodeWithRandomNodes, NodeWithRandomNodes>();
            NodeWithRandomNodes clonedNode = copyLeftToRightNode(orgNode,nodeMap);
            copyRandomNodes(orgNode,clonedNode,nodeMap);
            return clonedNode;
        }
    }

    public static void main(String args[]) {
        NodeWithRandomNodes root = new NodeWithRandomNodes(1);
        root.left = new NodeWithRandomNodes(2);
        root.right = new NodeWithRandomNodes(3);
        root.left.left = new NodeWithRandomNodes(4);
        root.left.right = new NodeWithRandomNodes(5);
        root.random = root.left.right;
        root.left.left.random = root;
        root.left.right.random = root.right;
        CloneBinaryTreeWithRandomNodes clone = new CloneBinaryTreeWithRandomNodes();
        NodeWithRandomNodes clonedNode = clone.copyBinaryTree(root);
        clone.inOrderPrint(root);
        System.out.println("");
        clone.inOrderPrint(clonedNode);
    }
}
