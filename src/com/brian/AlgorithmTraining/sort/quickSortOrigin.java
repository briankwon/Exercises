package com.brian.AlgorithmTraining.sort;

public class quickSortOrigin {
    private static int count = 0;
    public static void sort(int[] arr, int L, int R) {
        if (arr == null || arr.length == 0) {
            return;
        }

        quickSort(arr, L, R);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        int left = L, right = R;
        //int pivot = arr[(R + L) / 2];
        int pivot = arr[R];

        while (left <= right) {
            System.out.println("A : left = " + left + " right = " + right);
            while (left <= right && arr[left] < pivot) {
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }
            System.out.println("B : left = " + left + " right = " + right);
            if (left <= right) {
                swap(arr, left++, right--);
                System.out.println(++count);
                for (int ele : arr) {
                    System.out.print(ele + " ");
                }
                System.out.println(" ");
                System.out.println("C : left = " + left + " right = " + right);
            }
        }

        quickSort(arr, left, R);
        quickSort(arr, L, right);
    }

    public static void swap(int[] arr, int a ,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static double median2(int[] array){
        if(array==null || array.length==0) return 0;
        int left = 0;
        int right = array.length-1;
        int midIndex = right >> 1;
        int index = -1;
        while(index != midIndex){
            index = partition(array, left, right);
            if(index < midIndex) left = index + 1;
            else if (index > midIndex) right = index - 1;
            else break;
        }
        return array[index];
    }

    public static int partition(int[] array, int left, int right){
        if(left > right) return -1;
        int pos = right;
        right--;
        while(left <= right){
            while(left<pos && array[left]<=array[pos]) left++;
            while(right>left && array[right]>array[pos]) right--;
            if(left >= right) break;
            swap(array, left, right);
        }

        swap(array, left, pos);
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,845,4,1234,345,6567,758,5,432,4,2112,89,45,6,87,3465,5468,89};
        int[] arr1 = {3,2,4,0,6,4};

        sort(arr1, 0, arr1.length - 1);
        for (int ele : arr1) {
            System.out.print(ele + " ");
        }
        System.out.println(median2(arr));
    }
}
