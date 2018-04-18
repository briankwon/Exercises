package com.brian.AlgorithmTraining.offer;

public class Q53SearchInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4,5};
        System.out.println("first pos = " + search(arr, 3, true));
        System.out.println("first pos = " + search(arr, 3, false));
    }

    public static int search(int[] arr, int target, boolean flag) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                start = mid;
            } else if (arr[mid] > target) {
                end = mid;
            } else if (flag) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (arr[start] == target) {
            return start;
        }

        if (arr[end] == target) {
            return end;
        }

        return -1;
    }
}
