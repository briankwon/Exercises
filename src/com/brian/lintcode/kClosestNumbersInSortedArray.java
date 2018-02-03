package com.brian.lintcode;

/**
 * Created by briankwon on 2017/7/6.
 */
public class kClosestNumbersInSortedArray {
    public static int[] kClosestNumbers(int[] A, int target, int k) {
        int[] result = new int[k];

        if (A == null || A.length == 0) {
            return A;
        }
        if (k > A.length) {
            return A;
        }

        int index = firstIndex(A, target);
        System.out.println(index);

        int start = index - 1;
        System.out.println(start);
        int end = index;
        System.out.println(end);
        for (int i = 0; i < k; i++) {
            if (start < 0) {
                result[i] = A[end++];
            } else if (end >= A.length) {
                result[i] = A[start--];
            } else {
                if (target - A[start] <= A[end] - target) {
                    result[i] = A[start--];
                } else {
                    result[i] = A[end++];
                }
            }
        }
        return result;
    }

    private static int firstIndex(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] >= target) {
            return start;
        }
        if (A[end] >= target) {
            return end;
        }
        return A.length;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,4,4,7,8,30};
        System.out.println(A[8]);
        int[] result = kClosestNumbers(A, 31, 4);
        for (int element: result
             ) {
            System.out.println(element);
        }
    }
}
