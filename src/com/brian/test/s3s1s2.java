package com.brian.test;

public class s3s1s2 {
    public static boolean doRecur(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return processRecur(s1, 0, s2, 0, s3, 0);
    }

    public static boolean processDP(String s1, String s2, String s3) {
        return false;
    }

    //递归的定义，从s1的l1元素开始往后以及s2的l2元素开始往后的字符能否组成s3的l3元素开始之后的字符串
    public static boolean processRecur(String s1, int l1, String s2, int l2, String s3, int l3) {
        if (l1 == s1.length() && l2 == s2.length() && l3 == s3.length()) {
            return true;
        }
        boolean result = false;

        if (l1 < s1.length() && s1.charAt(l1) == s3.charAt(l3)) {
            result = processRecur(s1, ++l1, s2, l2, s3, ++l3);
        }

        if (!result && l2 < s2.length() && s2.charAt(l2) == s3.charAt(l3)) {
            result = processRecur(s1, l1, s2, ++l2, s3, ++l3);
        }

        return result;

    }

    public static boolean process(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i < s3.length(); i++) {
            if (p1 < s1.length() && c1[p1] == c3[i] && p2 < s2.length() && c2[p2] == c3[i]) {
                return process(s1.substring(p1 + 1), s2.substring(p2), s3.substring(i + 1)) ||
                        process(s1.substring(p1), s2.substring(p2 + 1), s3.substring(i + 1));
            }
            if (p1 < s1.length() && c1[p1] == c3[i]) {
                p1++;
            } else if (p2 < s2.length() && c2[p2] == c3[i]) {
                p2++;
            } else {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s1 = "abc";
        String s2= "def";
        String s3 = "adbecf";
        System.out.println(process(s1, s2, s3));
        System.out.println(doRecur(s1, s2, s3));

        String s4 = "aa";
        String s5 = "ab";
        String s6 = "aaba";
        System.out.println(process(s4, s5, s6));
    }
}
