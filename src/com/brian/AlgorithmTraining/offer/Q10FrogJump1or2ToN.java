package com.brian.AlgorithmTraining.offer;

public class Q10FrogJump1or2ToN {
    public static void main(String[] args) {
        System.out.println(process(10));
    }

    /**
     * 注意这里f(0) = f(1) = 1
     * @param n
     * @return
     */
    private static int process(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int f0 = 1;
        int f1 = 1;
        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = f0 + f1;
            f0 = f1;
            f1 = res;
        }

        return res;
    }
}
