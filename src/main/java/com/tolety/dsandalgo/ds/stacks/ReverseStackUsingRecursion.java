package com.tolety.dsandalgo.ds.stacks;

import java.util.Stack;

/*
You are not allowed to use loop constructs like while, for..etc, and you can only use the following
ADT functions on Stack S:
isEmpty(S)
push(S)
pop(S)

Solution:
The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty.
When the stack becomes empty, insert all held items one by one at the bottom of the stack.

For example, let the input stack be

    1  <-- top
    2
    3
    4
First 4 is inserted at the bottom.
    4 <-- top

Then 3 is inserted at the bottom
    4 <-- top
    3

Then 2 is inserted at the bottom
    4 <-- top
    3
    2

Then 1 is inserted at the bottom
    4 <-- top
    3
    2
    1
So we need a function that inserts at the bottom of a stack using the above given basic stack function.

void insertAtBottom((): First pops all stack items and stores the popped item in function call stack
using recursion. And when stack becomes empty, pushes new item and all items stored in call stack.

void reverse(): This function mainly uses insertAtBottom() to pop all items one by one and insert the
popped items at the bottom.
 */
public class ReverseStackUsingRecursion {


    public void insertAtBottom(int value, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(value);
        }
        else {
            int tmp = stack.pop();
            insertAtBottom(value, stack);
            stack.push(tmp);
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int value = stack.pop();
            reverse(stack);
            insertAtBottom(value, stack);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        System.out.print(stack);
        ReverseStackUsingRecursion reverseStackUsingRecursion = new ReverseStackUsingRecursion();
        reverseStackUsingRecursion.reverse(stack);
        System.out.print(stack);
    }
}
