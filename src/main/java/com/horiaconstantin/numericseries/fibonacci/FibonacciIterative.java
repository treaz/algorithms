package com.horiaconstantin.numericseries.fibonacci;

public class FibonacciIterative implements Fibonacci {

    public long solution(int n) {
        long a = 0;
        long b = 1;
        long c = 1;

        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

}