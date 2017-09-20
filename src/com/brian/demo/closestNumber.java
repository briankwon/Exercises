package com.brian.demo;

/**
 * Closest Number in Sorted Array
 * Created by briankwon on 2017/6/27.
 */
public class closestNumber {
    public static int binarySearch(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int index = firstIndex(A, target);

        if (index == 0) {
            return 0;
        }

        if (index == A.length) {
            return A.length - 1;
        }

        if (A[index] - target > target - A[index - 1]) {
            return index - 1;
        }

        return index;
    }

    public static int firstIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (target == A[mid]) {
                end = mid;
            }
            if (target > A[mid]) {
                start = mid;
            }
            if (target < A[mid]) {
                end = mid;
            }
        }

        if (target == A[start]) {
            return start;
        }

        if (target == A[end]) {
            return end;
        }

        return -1;
    }

    public static void main (String[] args) {
        System.out.println(binarySearch(new int[] {1,2,3,3,6}, 3));
    }
}
