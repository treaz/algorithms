package com.horiaconstantin.java.sdk;

import java.util.LinkedList;

public class Deque {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5, 6};
        java.util.Deque<Integer> deque = new LinkedList<>();
        for (int el : A) {
            deque.add(el);
        }

        System.out.println(deque.pop() == 1);
        System.out.println(deque.pollLast() == 6);
        deque.push(6);
        System.out.println(deque.getFirst() == 6);
    }
}
