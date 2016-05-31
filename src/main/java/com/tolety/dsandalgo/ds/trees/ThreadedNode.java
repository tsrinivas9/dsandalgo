package com.tolety.dsandalgo.ds.trees;

public class ThreadedNode {
    int key;
    ThreadedNode left, right;
    boolean rightThreaded, leftThreaded;
    public ThreadedNode(int item) {
        key = item;
        left = null;
        right = null;
        rightThreaded = false;
        leftThreaded = false;
    }
}
