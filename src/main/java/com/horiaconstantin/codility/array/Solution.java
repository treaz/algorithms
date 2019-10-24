package com.horiaconstantin.codility.array;

import java.util.Deque;
import java.util.LinkedList;

//https://app.codility.com/c/run/trainingSFKQAG-4ZE/
class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        if (A.length < 2) {
            return A;
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int el : A) {
            deque.add(el);
        }

        for (int i = 0; i < K; i++) {
            int last = deque.pollLast();
            deque.push(last);
        }

        Object[] objects = deque.toArray();
        int[] array = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            array[i] = (int) objects[i];
        }
        return array;
    }
}
