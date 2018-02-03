package com.brian.lintcode;

public class findMissingNumberII {
    public static void main(String[] args) {
        String str = "19201234567891011121314151618";
        int n = 20;
        System.out.println("The missing number is " + find(n, str));
    }

    private static int find(int n, String str) {
        if (n == 0 || str.length() == 0) {
            return -1;
        }

        int[] count = new int[n];
        for (int i = 1; i <= n; i++) {
            int decile = i / 10;
            if (decile >= 1) {
                count[decile]++;
            }
            count[i % 10]++;
        }

        char[] characters = str.toCharArray();
        for (char c: characters) {
            count[Character.getNumericValue(c)]--;
        }

        String res = "";
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                res = res.concat(String.valueOf(i));
            }
        }

        if (res == "12") {
            if (str.contains(res)) {
                return 21;
            } else {
                return 12;
            }
        }

        return Integer.valueOf(res);
    }
}
