package com.horiaconstantin.codility.timecomplexity;

//https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
public class TapeEquilibrium {

    public static int solution(int[] A) {
        int result = Integer.MAX_VALUE;
        int totalSum = 0;
        for (int val : A) {
            totalSum = totalSum + val;
        }
        int previousElemSum = 0;
        int intermResult;

        for (int i = 0; i < A.length - 1; i++) { //pay attention to the end of the loop, otherwise you'll do the iteration for the last element and that doesn't make sense
            int value = A[i];
            previousElemSum = previousElemSum + value;
            intermResult = Math.abs(totalSum - 2 * previousElemSum);
            if (intermResult < result) {
                result = intermResult;
            }
        }

        return result;
    }
}
