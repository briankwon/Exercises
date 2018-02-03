package com.brian.sort;

public class heapSortTest {
    public static void sort(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        //建立大根堆
        for (int i = 0; i < A.length; i++) {
            heapInsert(A, i);
        }
        int heapSize = A.length;
        swap(A, 0, --heapSize);
        while (heapSize > 0) {
            heapify(A, 0, heapSize);
            swap(A, 0, --heapSize);
        }
    }

    //插成大根堆
    public static void heapInsert(int[] A, int index) {
        while(A[index] > A[(index - 1) / 2]) {
            swap(A, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] A, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && A[left + 1] > A[left] ? left + 1 : left;
            largest = A[largest] > A[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(A, index, largest);
            index = largest;
            left = index * 2 + 1;
        }


    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {124,245,456,34,53,24,12,4,231,413,6,5,67,576,54,67};
        sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
