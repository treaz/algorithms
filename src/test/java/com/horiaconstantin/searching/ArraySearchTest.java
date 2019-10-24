package com.horiaconstantin.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraySearchTest {

    int[] inputArray = {123, 453, 213, 45, 1, 8, 44, 69};

    @Test
    public void testLinearSearch() {
        assertEquals(-1, ArraySearch.linearSearch(inputArray, 45311));
    }

}
