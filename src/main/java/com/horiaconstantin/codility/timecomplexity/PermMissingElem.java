package com.horiaconstantin.codility.timecomplexity;

import java.util.Arrays;

public class PermMissingElem {

    public static int solution(int[] A) {
        int missing = 1; // missing number 1 already
        Arrays.sort(A);

        // check numbers one by one
        for (int i = 0; i < A.length; i++) {
            if (A[i] == missing) {    // we found an existing number !
                missing = A[i] + 1;    // add +1 and keep checking
            } else break;
        }
        return missing;
    }
}
