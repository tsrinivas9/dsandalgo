package com.tolety.dsandalgo.ds.stacks;

/*
The idea is to start two stacks from two extreme corners of arr[].
stack1 starts from the leftmost element, the first element in stack1
is pushed at index 0. The stack2 starts from the rightmost corner,
the first element in stack2 is pushed at index (n-1).
Both stacks grow (or shrink) in opposite direction. To check for overflow,
all we need to check is for space between top elements of both stacks.
 */
public class TwoStacksInAnArray {

    int array[];
    int stack1Idx = -1;
    int stack2Idx = -1;

    public TwoStacksInAnArray(int size) {
        array = new int[size];
        stack1Idx = 0;
        stack2Idx = size - 1;
    }

    public boolean push1(int value) {
        if (stack1Idx != stack2Idx) {
            array[stack1Idx++] = value;
            return true;
        }
        return false;
    }

    public boolean push2 (int value) {
        if (stack1Idx != stack2Idx) {
            array[stack2Idx--] = value;
            return true;
        }
        return false;
    }

    public int pop1 () {
        if (stack1Idx >= 0) {
            return array[--stack1Idx];
        }
        return - 1;
    }

    public int pop2 () {
        if (stack2Idx < array.length) {
            return array[++stack2Idx];
        }
        return - 1;
    }

    public static void main(String args[]) {
        TwoStacksInAnArray ts = new TwoStacksInAnArray(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);

        System.out.println("Popped element from stack 1 is " + ts.pop1());

        ts.push2(40);

        System.out.println("Popped element from stack 2 is " + ts.pop2());

    }
}
