package com.horiaconstantin.misc;

public class Fibonacci {

    static int calculateIterative(int n) {
        int a = 0;
        int b = 1;
        int c = 1;

        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

}