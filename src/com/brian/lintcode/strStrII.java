package com.brian.lintcode;

/**
 * Created by briankwon on 2017/7/7.
 */
public class strStrII {
    public static int BASE = 1000000;

    public static int strStr2(String source, String target) {

        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }

        int n = source.length();
        int m = target.length();

        if (m == 0) {
            return 0;
        }

        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }

        int targetCode = 0;
        //hashcode of target string
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }

        int hashCode = 0;
        for (int i = 0; i < n; i++) {
            //abc + d
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            //如果不够m个字符的话没有必要进行后面的操作，continue到i=m，这时hashCode对应的字符串长度和target相同。
            if (i < m - 1) {
                continue;
            }

            //abcd - a
            if (i >= m) {
                hashCode = hashCode - (source.charAt(i - m) * power) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }
            //   i
            //abcde
            // bcd
            // m = 3
            if (hashCode == targetCode) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }

        return -1;








//        if (source == null || target == null) {
//            return -1;
//        }
//        int m = target.length();
//        if (m == 0) {
//            return 0;
//        }
//        // 31 ^ m
//        int power = 1;
//        for (int i = 0;i < m; i++) {
//            power = (power * 31) % BASE;
//        }
//        //hash(cde)
//        int targetCode = 0;
//        for (int i = 0;i < m; i++) {
//            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
//        }
//
//        int hashCode = 0;
//        //hash
//        for (int i = 0; i < source.length(); i++) {
//            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
//            //直到得到hash(abc)
//            if (i < m - 1) {
//                continue;
//            }
//            //在i ＝ m - 1 = 2 时不进入这个if语句中
//            //此时比较h(abc) =? h(cde)
//            if (i >= m) {
//                hashCode = (hashCode - power * source.charAt(i - m)) % BASE;
//                if (hashCode < 0) {
//                    hashCode = hashCode + BASE;
//                }
//            }
//
//            if (hashCode == targetCode) {
//                if (source.substring(i - m + 1, i + 1).equals(target)) {
//                    return i - m + 1;
//                }
//            }
//        }
//
//        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr2("abcde", "cde"));
    }
}