package com.horiaconstantin.codility.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    @Test
    public void solution() {
        int[] actual = new Solution().solution(new int[]{3, 8, 9, 7, 6}, 3);
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, actual);
    }

    @Test
    public void solution2() {
        int[] actual = new Solution().solution(new int[]{1, 2, 3, 4}, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, actual);
    }

    @Test
    public void solution3() {
        int[] actual = new Solution().solution(new int[]{}, 1);
        assertArrayEquals(new int[]{}, actual);
    }
}