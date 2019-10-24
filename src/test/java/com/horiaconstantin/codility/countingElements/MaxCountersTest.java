package com.horiaconstantin.codility.countingElements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MaxCountersTest {

    @Test
    public void solution() {
        int[] solution = MaxCounters.solution(2, new int[]{1, 2, 1});
        assertArrayEquals(new int[]{2, 1}, solution);
    }

    @Test
    public void solution2() {
        int[] solution = MaxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, solution);
    }
}