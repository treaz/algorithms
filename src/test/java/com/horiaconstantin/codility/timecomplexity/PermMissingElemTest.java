package com.horiaconstantin.codility.timecomplexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermMissingElemTest {

    @Test
    public void solution() {
        assertEquals(4, PermMissingElem.solution(new int[]{2, 3, 1, 5}));
//        assertEquals(2, PermMissingElem.solution(new int[]{1}));
        assertEquals(3, PermMissingElem.solution(new int[]{2, 1, 4}));
        assertEquals(1, PermMissingElem.solution(new int[]{2, 3, 4}));
        assertEquals(1, PermMissingElem.solution(new int[]{}));
        assertEquals(1, PermMissingElem.solution(new int[]{2}));
        assertEquals(5, PermMissingElem.solution(new int[]{2, 3, 1, 4}));
    }
}