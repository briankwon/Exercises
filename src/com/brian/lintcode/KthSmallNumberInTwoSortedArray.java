package com.brian.lintcode;

public class KthSmallNumberInTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {3,5,6,7};
        int[] b = {1,2,4,8};
        System.out.println(findKthSMallest(a, b, 4));
    }

    private static int findKthSMallest(int[] A, int[] B, int k) {
        int a_offset = 0, b_offset = 0;
        if (A.length + B.length < k) return -1;

        while (true) {

            if (a_offset < A.length) {
                if (b_offset == B.length) {
                    continue;
                }
                while (A[a_offset] <= B[b_offset]) {
                    a_offset++;
                    if (a_offset + b_offset == k) return A[--a_offset];
                }
            }
            if (b_offset < B.length) {
                if (a_offset == A.length) {
                    continue;
                }
                while(A[a_offset] >= B[b_offset]) {
                    b_offset++;
                    if (a_offset + b_offset == k) return B[--b_offset];
                }
            }
        }
    }
}
