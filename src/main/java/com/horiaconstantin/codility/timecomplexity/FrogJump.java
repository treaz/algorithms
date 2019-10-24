package com.horiaconstantin.codility.timecomplexity;

public class FrogJump {

    public static int solution(int X, int Y, int D) {
        int jumps;
        int totalDistance = Y - X;
        jumps = totalDistance / D;
        if (totalDistance % D != 0) {
            jumps++;
        }
        return jumps;
    }
}
