package com.tolety.dsandalgo.ds.queues;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n.

Examples:

Input: n = 2
Output: 1, 10

Input: n = 5
Output: 1, 10, 11, 100, 101
 */
public class GenerateBinaryNumbers {

    public void generateAndPrintBinary(int n) {
        // Create a queue of type String
        Queue<String> queue = new LinkedList<String>();

        // Insert "1" into the queue
        queue.add("1");

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (int i = 1; i <= n; i++) {
             sb1.setLength(0);
             sb2.setLength(0);
             String previous = queue.poll();
             System.out.print(previous + " ");
             sb1.append(previous + "0");
              queue.add(sb1.toString());
             sb2.append(previous + "1");
            queue.add(sb2.toString());
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        GenerateBinaryNumbers bn = new GenerateBinaryNumbers();
        bn.generateAndPrintBinary(2);
        bn.generateAndPrintBinary(5);
    }
}
