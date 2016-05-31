package com.tolety.dsandalgo.ds.queues;

import java.util.Deque;
import java.util.LinkedList;

/*
Maximum of all subarrays of size k (Added a O(n) method)
Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

Examples:

Input :
arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
k = 3
Output :
3 3 4 5 5 5 6

Input :
arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
k = 4
Output :
10 10 10 15 15 90 90

 */
@SuppressWarnings("ALL")
public class MaxOfAllSubArrays {

    public void printKMax(int[] input, int k) {
        // Create a Deque that will store indexes of array of elements
        // The queue will store indexes of useful elements in every
        // window and it will maintain decreasing order of values from front to rare.
        // i.e. deQueue [front] to deQueue [rare] is stored in decreasing order.
        Deque<Integer> deQueue = new LinkedList<Integer>();

        //  Process first k elements of input
        int i = 0;
        for (i = 0; i < k; i++) {
            while (!deQueue.isEmpty() && input[deQueue.peekLast()] < input[i]) {
                    deQueue.removeLast(); // remove from rare
            }
            // Add index of the element at the rare of the queue
            deQueue.addLast(i);
        }

        for (; i < input.length; i++) {
            // print the element at the front of the queue
            // as it is the largest element of previous window.
            System.out.print(input[deQueue.peekFirst()] + " ");

            // remove elements which are out of current window
            while (!deQueue.isEmpty() && deQueue.peekFirst() < i - k) {
                deQueue.removeFirst(); // remove from front of the queue
            }

            // remove all the smaller than currently  being added element
            while (!deQueue.isEmpty() && input[deQueue.peekLast()] < input[i]) {
                deQueue.removeLast();
            }

            // add index of current element at the last.
            deQueue.addLast(i);

        }

        // print the maximum element of last window.
        System.out.println(input[deQueue.removeFirst()]);

    }

    public static void main(String args[]) {

        int[] input1 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int[] input2 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};

        MaxOfAllSubArrays max = new MaxOfAllSubArrays();
        max.printKMax(input1, 3);
        max.printKMax(input2, 4);
    }
}
