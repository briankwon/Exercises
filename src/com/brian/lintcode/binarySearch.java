package com.brian.lintcode;

public class binarySearch {
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid;
            } else if (arr[mid] > target) {
                end = mid;
            } else {
                return mid;
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

    public static void main(String[] args) {
        int[] arr = {13,5,6,8,98,8765,4,32,2,35,67,65,432,23,3,4,3,21};
        System.out.println(search(arr, 8));
    }
}
