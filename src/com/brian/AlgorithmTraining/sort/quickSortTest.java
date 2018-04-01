package com.brian.AlgorithmTraining.sort;

public class quickSortTest {
    private static void sort(int[] arr, int L, int R) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (L < R) {
            swap(arr, L + (int) Math.random() * (L - R + 1), R );
            int[] p = partition(arr, L, R);
            sort(arr, L, --p[0]);
            sort(arr, ++p[1], R);
        }
    }

    private static int[] partition(int[] arr, int L, int R) {
        int left = L - 1;
        int right = R;

        while (L < right) {
            if (arr[L] < arr[R]) {
                swap(arr, ++left, L++);
            } else if (arr[L] == arr[R]) {
                L++;
            } else {
                swap(arr, --right, L);
            }
        }

        swap(arr, R, right);
        return new int[] {++left, right};
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void insertSort(int[] arr, int L, int R) {
        for (int i = L + 1; i <= R; i++) {
            for (int j = i - 1; j >= L; j--) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {654,6,8,1321,4,7,8,4,5,65,51,84,9,5,18,49,1,614};
        sort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
