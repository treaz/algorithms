package com.horiaconstantin.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class RadixSortTest {

    @Test
    public void test() {
        int[] input = {329, 457, 657, 839, 436, 720, 355};
        int[] result = {329, 355, 436, 457, 657, 720, 839};
        assertArrayEquals(new RadixSort().sort(input, 3), result);
    }

}
