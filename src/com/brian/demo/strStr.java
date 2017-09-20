package com.brian.demo;

/**
 * Created by briankwon on 2017/6/27.
 */
public class strStr {
    public static int strStr(String source, String target) {
        int n = source.length();
        int m = target.length();

        if (source == null || target == null || n < m) {
            return -1;
        }

        if (m == 0) {
            return 0;
        }

        for (int i = 0; i < n - m + 1; i++) {
            int j;

            for (j = 0; j < m; j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    public static int strStr1(String source, String target) {
        int n = source.length();
        int m = target.length();

        if (source == null || target == null || n < m) {
            return -1;
        }

        if (m == 0) {
            return 0;
        }

        for (int i = 0; i < n - m + 1; i++) {
            int k = i;
            int j = 0;

            while (source.charAt(k) == target.charAt(j) && j < m && k < n) {
                k++;
                j++;
                if (j == m) {
                    return k;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int position = strStr("source", "ce");
        System.out.println(position);
        System.out.println(strStr1("source", "ce"));
    }
}
