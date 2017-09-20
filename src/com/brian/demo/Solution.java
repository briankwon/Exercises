package com.brian.demo;

import static java.lang.Math.*;

/**
 * Created by briankwon on 2017/5/1.
 */
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public static int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start < end) {
            int mid = start + (end - start)/2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (start == end) {
            if (abs(A[start] - target) <= abs(A[end + 1] - target)) {
                return start;
            } else {
                return end + 1;
            }
        }
        if (abs(A[start] - target) <= abs(A[end] - target)) {
            return start;
        } else {
            return end;
        }
    }

    public static void main(String[] args) {
        int[] A = {1,4,6,8};
        int target = 3;
        System.out.println(closestNumber(A, target));
    }
}
