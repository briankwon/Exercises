package com.brian.lintcode;

public class KthBiggestNumber {
    public static int findKth(int[] a, int n, int K) {
        // write code here
        if (a == null || n == 0) {
            return -1;
        }

        return partition(a, 0, n - 1, K);
    }

    public static int partition(int[] arr, int L, int R, int K) {
        if (L == R) {
            return arr[R];
        }

        int left = L - 1;
        int right = R;
        int index = L;

        while (index < right) {
            if (arr[index] < arr[R]) {
                swap(arr, ++left, index++);
            } else if (arr[index] == arr[R]) {
                index++;
            } else {
                swap(arr, --right, index);
            }
        }

        left++;
        swap(arr, R, right);

        if (R - right + 1 > K) {
            return partition(arr, right + 1, R, K);
        } else if (K <= (R - left + 1) && K >= (R - right + 1)) {
            return arr[right];
        } else {
            return partition(arr, L, left - 1, K - (R - left + 1));
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        //System.out.println(findKth(new int[] {1,3,5,2,2}, 5, 3));
        System.out.println(findKth(new int[] {1,1,1,3,5,2,2}, 7, 5));
    }
}
