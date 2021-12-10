package com.horiaconstantin.bitwise;

//    https://app.codility.com/demo/results/trainingVGQ759-WRP/
public class OddOccurrencesInArray {

    static int solution(int[] a) {
        int sum = 0;
        for (int val : a) {
            sum = sum ^ val;
        }
        return sum;
    }
}
