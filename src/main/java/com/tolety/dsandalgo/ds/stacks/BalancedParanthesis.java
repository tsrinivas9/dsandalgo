package com.tolety.dsandalgo.ds.stacks;

import java.util.Stack;

/**
 * Created by HARIPRIYA on 5/12/16.
 */
/*
Algorithm:
1) Declare a character stack S.
2) Now traverse the expression string exp.
    a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
    b) If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the matching starting bracket then fine else parenthesis are not balanced.
3) After complete traversal, if there is some starting bracket left in stack then “not balanced”
 */
public class BalancedParanthesis {

    public boolean isMatchingBraces(char fromStack, char fromString) {
        if (fromStack == '(' && fromString == ')') {
            return true;
        }
        else if (fromStack == '{' && fromString == '}') {
            return true;
        }
        else if (fromStack == '[' && fromString == ']') {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkForBalancedPranthesis(String input) {
        boolean ret = false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char first = input.charAt(i);
            if (first == '(' || first == '{'  || first == '[') {
                stack.push(first);
            }
            else if (first == ')'  || first == '}' || first == ']') {
                char second = stack.peek();
                if (isMatchingBraces(second, first)) {
                    stack.pop();
                }
            }
            else {
                continue;
            }
        }
        if (stack.isEmpty()) {
            ret = true;
        }
        return ret;
    }

    public static void main(String args[]) {
        String sample = "[()]{}{[()()]()}";
        BalancedParanthesis balancedParanthesis = new BalancedParanthesis();
        boolean ret  = balancedParanthesis.checkForBalancedPranthesis(sample);
        System.out.println("String is balanced : " + ret);
    }
}
