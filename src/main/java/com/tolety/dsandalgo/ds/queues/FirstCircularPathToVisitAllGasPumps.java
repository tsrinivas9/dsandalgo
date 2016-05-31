package com.tolety.dsandalgo.ds.queues;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/*
Suppose there is a circle. There are n gas pumps on that circle. You are given two sets of data.

1. The amount of gas that every gas pump has.
2. Distance from that gas pump to the next gas pump.

Calculate the first point from where a truck will be able to complete the circle (The truck will
stop at each gas pump and it has infinite capacity). Expected time complexity is O(n). Assume
for 1 galon gas, the truck can go 1 unit of distance.

For example, let there be 4 gas pumps with amount of gas and distance to next gas pump
value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where truck can make a
circular tour is 2nd gas pump. Output should be “start = 1″ (index of 2nd gas pump).

A Simple Solution is to consider every gas pumps as starting point and see if there is a possible
tour. If we find a starting point with feasible solution, we return that starting point. The worst
case time complexity of this solution is O(n^2).

We can use a Queue to store the current tour. We first enqueue first gas pump to the queue, we
keep enqueueing gas pumps till we either complete the tour, or current amount of gas becomes
negative. If the amount becomes negative, then we keep dequeueing gas pumps till the current
amount becomes positive or queue becomes empty.

*/
public class FirstCircularPathToVisitAllGasPumps {

    static class GasPump {
        int gas;
        int distance;
        public GasPump(int gas, int distance) {
           this.gas = gas;
           this.distance = distance;
        }
    }
    // This method will return a list with the tour.
    // If none then it will return null;
    public void printTour(Queue<GasPump> gasPumps) {
        // first calculate total gas and total distance.
        // Total gas must be >= total distance.
        // Assumption is that at the start the truck has zero gasoline.
        int queueSize = gasPumps.size();
        int totalGas = 0;
        int totalDistance = 0;
        for (int i = 0; i < queueSize; i++) {
            GasPump pump = gasPumps.remove();
            totalDistance = totalDistance + pump.distance;
            totalGas = totalGas + pump.gas;
            gasPumps.add(pump);
        }
        if (totalDistance > totalGas) {
            // There is no possible route for truck to
            // travel to all the gas pumps.
            System.out.println("There is no possible solution as the total distance is greater than total gas.");
        }

        for (int idxI = 0; idxI < queueSize; idxI++) {
            totalDistance = 0;
            totalGas = 0;
            boolean found = true;
            for (int idxJ = 0; idxJ < queueSize; idxJ++) {
                GasPump pump = gasPumps.remove();
                totalDistance += pump.distance;
                totalGas += pump.gas;
                if (totalGas < totalDistance) {
                    found = false;
                }
                gasPumps.add(pump);
            }
            if (!found) {
                GasPump pump = gasPumps.remove();
                gasPumps.add(pump);
            }
            else {
                for (int idxK = 0; idxK < queueSize; idxK++) {
                    GasPump pump = gasPumps.remove();
                    System.out.println("Gas = " + pump.gas + " Distance = " + pump.distance);
                    gasPumps.add(pump);
                }
                break;
            }
        }
    }

    public static void main(String args[]) {
        // First one is amount of Gas. Second one is distance to next pump
        Queue<GasPump> queue = new ArrayBlockingQueue<GasPump>(4);
        queue.add(new GasPump(4,6));
        queue.add(new GasPump(6,4));
        queue.add(new GasPump(7,3));
        queue.add(new GasPump(4,5));

        FirstCircularPathToVisitAllGasPumps tour = new FirstCircularPathToVisitAllGasPumps();
        tour.printTour(queue);
    }

}
