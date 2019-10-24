package com.horiaconstantin.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountSortTest {
    @Test
    public void test() {
        int[] input = {2, 5, 3, 0, 2, 3, 0, 3};
        int maxVal = 5;
        int[] result = {0, 0, 2, 2, 3, 3, 3, 5};
        assertArrayEquals(new CountSort().sort(input, maxVal), result);
    }
}