package com.brian.AlgorithmTraining.sort;

public class quickSortTest {
    private static void sort(int[] arr, int L, int R) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (L < R) {
            if (R - L + 1 < 8) {
                insertSort(arr, L, R);
                return;
            }
            //swap
            swap(arr, L + (int) Math.random() * (R - L + 1), R);
            int[] p = partition(arr, L, R);
            sort(arr, L, --p[0]);
            sort(arr, ++p[1], R);
        }
    }

    //不稳定，试想[4,2,4,3]，第一次比较因为4 > 3，第一个4和第二个4会交换位置
    private static int[] partition(int[] arr, int L, int R) {
        int left = L - 1;
        int right = R;

        while (L < right) {
            if (arr[L] == arr[R]) {
                L++;
            } else if (arr[L] < arr[R]) {
                swap(arr, ++left, L++);
            } else {
                swap(arr, --right, L);
            }
        }

        swap(arr, right, R);
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
