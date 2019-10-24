package com.horiaconstantin.codility.countingElements;

import com.horiaconstantin.utils.ArrayUtils;

import java.util.*;

//https://app.codility.com/c/run/trainingJK397U-QYW/
public class MaxCounters {

    public static int[] solution(int N, int[] A) {
        Map map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            result.add(0);
        }

        int biggestValue = 0;

        for (int value : A) {
            System.out.println("operation:" + value);
            result.forEach(System.out::println);
            if (1 <= value && value <= N) {
                int counterValue = result.get(value - 1);
                int newCounterValue = counterValue + 1;
                result.set(value - 1, newCounterValue);
                if (biggestValue < newCounterValue) {
                    biggestValue = newCounterValue;
                }
            } else {
                int finalBiggestValue = biggestValue;
                System.out.println("finalBiggestValue: " + finalBiggestValue);
                Collections.fill(result, biggestValue);
            }
        }

        return ArrayUtils.convertIntegers(result);
    }
}
