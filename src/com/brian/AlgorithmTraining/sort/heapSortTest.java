package com.brian.AlgorithmTraining.sort;

public class heapSortTest {
//    public static void sort(int[] arr) {
//        if (arr == null || arr.length == 0) {
//            return;
//        }
//
//        //插成大根堆
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
//
//        int heapSize = arr.length;
//        //取出根顶，heapSize - 1
//        swap(arr, 0, --heapSize);
//
//        //堆化并取出根顶，heapSize - 1
//        while (heapSize > 0) {
//            heapify(arr, 0, heapSize);
//            swap(arr, 0, --heapSize);
//        }
//    }
//
//    public static void heapInsert(int[] arr, int index) {
//        while (arr[index] > arr[(index - 1) / 2]) {
//            swap(arr, index, (index - 1) / 2);
//            index = (index - 1) / 2;
//        }
//    }
//
//    public static void heapify(int[] arr, int index, int heapSize) {
//        int left = index * 2 + 1;
//
//        while (left < heapSize) {
//            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
//            largest = arr[largest] > arr[index] ? largest : index;
//
//            if (largest == index) {
//                break;
//            }
//
//            swap(arr, largest, index);
//            index = largest;
//            left = index * 2 + 1;
//        }
//    }
//
    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        //插成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);

        //老是忘记这个while
        while (heapSize > 0) {
            //记得heapify的思想和传入的参数
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //记住heapInsert的思想和传入的参数
    //这里对于每一个在index的元素，从index开始到大根堆顶一层一层向上换，而index是从0开始到arr.length-1结束的，因此会把整个大根堆插出来
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        //重新整理成大根堆
        int left = index * 2 + 1;

        //这个while老是忘，如果没有它的话堆化过程就没有结束点了
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;

            if (largest == index) {
                break;
            }

            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    public static void main(String[] args) {
        int[] arr = {124,245,456,34,53,24,12,4,231,413,6,5,67,576,54,67};
        sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

