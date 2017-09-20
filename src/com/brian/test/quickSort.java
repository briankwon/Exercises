package com.brian.test;
public class quickSort {
    private static String source = "abcdefg";
    private static String target = "cde";
    private static int BASE = 2048;

    public static void main (String[] args) {
        System.out.println(rabinKarp(source, target));
    }

    public static int rabinKarp (String source, String target) {
        if (source == null || target == null || source == "") {
            return -1;
        }

        if (target == "") {
            return -1;
        }

        int m = target.length();

        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }
        //hash value of target
        int targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }

        int hashCode = 0;
        for (int i = 0; i < source.length();i++ ) {
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            if (i < m) {
                continue;
            }

            if (i >= m) {//target = cde source = abcdefg
                hashCode = (hashCode - power * source.charAt(i - m)) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }

            if (hashCode == targetCode) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }
        return  -1;
    }
}

















