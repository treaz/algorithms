package com.horiaconstantin.misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {

    @Test
    public void calculateIterative() {
        assertEquals(0, Fibonacci.calculateIterative(0));
        assertEquals(1, Fibonacci.calculateIterative(1));
        assertEquals(1, Fibonacci.calculateIterative(2));
        assertEquals(2, Fibonacci.calculateIterative(3));
        assertEquals(55, Fibonacci.calculateIterative(10));
    }
}