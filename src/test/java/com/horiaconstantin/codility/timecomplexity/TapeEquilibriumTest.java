package com.horiaconstantin.codility.timecomplexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TapeEquilibriumTest {

    @Test
    public void solution() {
        assertEquals(1, TapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3}));
        assertEquals(0, TapeEquilibrium.solution(new int[]{3, 3}));
        assertEquals(3, TapeEquilibrium.solution(new int[]{3, 6}));
        assertEquals(3, TapeEquilibrium.solution(new int[]{6, 3}));
        assertEquals(990, TapeEquilibrium.solution(new int[]{6, 4, 1000}));
        assertEquals(2000, TapeEquilibrium.solution(new int[]{-1000, 1000}));
    }
}