package com.horiaconstantin.bitwise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddOccurrencesInArrayTest {

    @Test
    public void oddOccurrencesInArray() {
        int actual = OddOccurrencesInArray.solution(new int[]{2, 2, 3, 3, 4});
        assertEquals(4, actual);

        assertEquals(7, OddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
    }
}