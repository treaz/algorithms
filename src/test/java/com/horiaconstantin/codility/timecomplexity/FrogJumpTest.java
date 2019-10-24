package com.horiaconstantin.codility.timecomplexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FrogJumpTest {

    @Test
    public void solution() {
        assertEquals(3, FrogJump.solution(10, 85, 30));
        assertEquals(0, FrogJump.solution(10, 10, 30));
        assertEquals(1, FrogJump.solution(10, 11, 30));
        assertEquals(999, FrogJump.solution(1, 1000, 1));
    }
}