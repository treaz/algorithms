package com.horiaconstantin.numericseries.fibonacci;

import java.util.ArrayDeque;
import java.util.Deque;

public class FibonacciWithStack implements Fibonacci {

    @Override
    public long solution(int n) {
        if (n <= 1) {
            return n;
        }
        Deque<Long> stack = new ArrayDeque<>();
        stack.push(0L);
        stack.push(1L);
        for (int i = 2; i <= n; i++) {
            long top = stack.pop();
            long bot = stack.pop();
            stack.push(top);
            stack.push(top + bot);
        }
        return stack.peek();
    }
}
