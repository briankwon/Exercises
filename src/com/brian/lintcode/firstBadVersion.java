package com.brian.lintcode;

/**
 * Created by briankwon on 2017/6/28.
 */
public class firstBadVersion {
    public static int findFirstBadVersion(int n) {
       int start = 1;
       int end = n;

       while (start + 1 < end) {
           int mid = start + (end - start) / 2;

           if (isBadVersion(mid)) {
               end = mid;
           } else {
               start = mid;
           }
       }

       if (isBadVersion(start)) {
           return start;
       } else {
           return end;
       }


    }

    public static boolean isBadVersion(int n) {
        if (n >= 6) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(findFirstBadVersion(18));

    }
}
