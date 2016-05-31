package com.tolety.dsandalgo.ds.linkedlist;

import java.util.Stack;

public class ReverseStringWithStack {

    public String reverseString (String input) {
        StringBuffer output = new StringBuffer();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return output.toString();
    }

    public static void main(String args[]) {
        String input = "Testing Reverse String using stack";
        ReverseStringWithStack reverseStringWithStack = new ReverseStringWithStack();
        System.out.println(reverseStringWithStack.reverseString(input));
    }
}
