package com.tolety.dsandalgo.ds.stacks;

import java.util.Stack;

public class InFixToPostFix {



    // this method tells if "c" is an operator.
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
    }

    // this method tells if "c" is a space
    private boolean isSpace (char c) {
        return c == ' ';
    }

    // this method tells if op1 has lower precedence than op2
    // op1 is left operator op2 is the right operator
    // The assumed operators are +, - , *, /, ^,
    private boolean isLowerPrecedence (char op1, char op2) {

            switch (op1) {

                case '+' :
                case '-' :
                    return !(op2 == '+' || op2 == '-');
                case '*' :
                case '/' :
                    return (op2 == '^' || op2 == '(');
                case '(' :
                    return true;
                default :
                    return false;
            }
    }

    private String covert(String infix) {

        // operator stack
        java.util.Stack<Character> operatorStack = new Stack<Character>();

        StringBuffer postFix = new StringBuffer();

        char c; // First character of the a token

        int len = infix.length();

        for (int i = 0; i < len; i++) {
            c = infix.charAt(i);
            // Skip to next character in the string if a space is encountered.
            if (isSpace(c)) {
                continue;
            }
            else if (isOperator(c)) {
                while (!operatorStack.isEmpty()
                        && !isLowerPrecedence(operatorStack.peek(),c)) {
                    // Operator in the stack doesn't have lower precedence.
                    // It goes first before the current operator.
                    postFix.append(" ").append(operatorStack.pop());
                }

                if (c == ')') {
                    // Output the remaining operators from the stack.
                    char op = operatorStack.pop();
                    while(op != '(') {
                        postFix.append(" ").append(op);
                        op = operatorStack.pop();
                    }
                }
                else {
                    operatorStack.push(c);
                }
            }
            else {
                // It is an operand. Add it to the StringBuffer
                postFix.append(" ").append(c);
            }
        }

        // String is processed. Output all the remaining operators
        while (!operatorStack.isEmpty()) {
            postFix.append(" ").append(operatorStack.pop());
        }
        return postFix.toString();
    }

    public static void main(String args[]) {
        String[] testString = {"2 + 3 * 4 / 5",
                "2*3 - 4 + 5 / 6",
                " 35 - 42* 17 /2 + 10",
                " 33.2 - 17.5 * 2.0 ^ 3.2",
                "3 * (4 + 5)",
                "3 * ( 4 - (5+2))/(2+3)",
                "a+b*(c^d-e)^(f+g*h)-i"};
        InFixToPostFix inFixToPostFix = new InFixToPostFix();
        for (int i = 0; i < testString.length; i++) {
            System.out.println("Input = " + testString[i] + " Output = " + inFixToPostFix.covert(testString[i]));
        }
    }
}
