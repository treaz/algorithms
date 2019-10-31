package com.horiaconstantin.numericseries.fibonacci;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {

    @ParameterizedTest
    @ValueSource(classes = {FibonacciIterative.class, FibonacciRecursive.class, FibonacciWithStack.class})
    void calculateMultiple(Class<Fibonacci> clazz) throws Exception {
        Fibonacci algo = clazz.getConstructor().newInstance();

        assertEquals(0, algo.solution(0));
        assertEquals(1, algo.solution(1));
        assertEquals(1, algo.solution(2));
        assertEquals(2, algo.solution(3));
        assertEquals(55, algo.solution(10));
        assertEquals(6765, algo.solution(20));
    }
}