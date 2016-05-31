package com.tolety.dsandalgo.ds.stacks;

import java.util.Stack;

/*
Given a stack, sort it using recursion. Use of any loop constructs like while, for..etc is not allowed. We can only use the following ADT functions on Stack S:

is_empty(S)  : Tests whether stack is empty or not.
push(S)	     : Adds new element to the stack.
pop(S)	     : Removes top element from the stack.
top(S)	     : Returns value of the top element. Note that this
               function does not remove element from the stack.
Example:

Input:  -3  <--- Top
        14
        18
        -5
        30

Output: 30  <--- Top
        18
        14
        -3
        -5

We strongly recommend you to minimize your browser and try this yourself first.
This problem is mainly a variant of Reverse stack using recursion.

The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty. When the stack becomes empty, insert all held items one by one in sorted order. Here sorted order is important.


Algorithm
We can use below algorithm to sort stack elements:

sortStack(stack S)
	if stack is not empty:
		temp = pop(S);
		sortStack(S);
		sortedInsert(S, temp);
Below algorithm is to insert element is sorted order:

sortedInsert(Stack S, element)
	if stack is empty OR element > top element
		push(S, elem)
	else
		temp = pop(S)
		sortedInsert(S, element)
		push(S, temp)
 */
public class SortStackUsingRecursion {

    public void sortedInsert(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
        }
        else {
            int top = stack.peek();
            if (element > top) {
                stack.push(element);
            }
            else {
                int temp = stack.pop();
                sortedInsert(stack,element);
                stack.push(temp);
            }
        }
    }

    public void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            sortedInsert(stack,temp);
        }
    }
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-3);
        stack.push(14);
        stack.push(18);
        stack.push(-5);
        stack.push(30);
        System.out.println(stack);
        SortStackUsingRecursion sortStackUsingRecursion = new SortStackUsingRecursion();
        sortStackUsingRecursion.sortStack(stack);
        System.out.println(stack);
    }
}
