package com.brian.bitOperation;

//找出一个数组里面只出现一次的两个数字
public class findTwoNumbersInArrayAppearOnce {
    public static int[] find(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        //得到两个不同值的异或值
        int XORResult = 0;

        for (int i = 0; i < arr.length; i++) {
            XORResult ^= arr[i];
        }

        int index = findPlaceOfFirst1(XORResult);
        int[] result = new int[2];

        for (int i = 0; i < arr.length; i++) {
            if (classify(arr[i], index) == 1) {
                result[0] ^= arr[i];
            } else {
                result[1] ^= arr[i];
            }
        }

        return result;
    }

    public static int findPlaceOfFirst1(int num) {
        int index = 0;

        while ( (num & 1) == 0 && index < 32) {
            num = num >> 1;
            index++;
        }

        return index;
    }

    public static int classify(int num, int index) {
        num = num >> index;
        return (num & 1);
    }

    public static void main(String[] args) {
        int[] arr= {1, 10, 11, 11, 100, 100};
        for (int num : find(arr)) {
            System.out.println(num + " ");
        }
    }
}
