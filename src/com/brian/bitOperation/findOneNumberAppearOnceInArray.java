package com.brian.bitOperation;

//数组A中，除了某一个数字x之外，其他数字都出现了三次，而x出现了一次。请给出最快的方法，找到x。
public class findOneNumberAppearOnceInArray {
    public static int find(int[] arr) {
        if (arr == null || arr.length < 4) {
            return 0;
        }

        int[] count = new int[32];

        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < arr.length; j++) {
                int bit = arr[j] & 1;
                count[i] += bit;
                arr[j] >>= 1;
            }
        }

        int result = 0;

        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 != 0) {
                result = set(result, i);
            }
        }

        return result;
    }

    //注意Java的值传递问题
    public static int set(int num, int index) {
        return num |= (1 << index);
    }

    public static void main(String[] args) {
        int[] arr = {1,455,455,455,333,333,333,657,657,657};
        System.out.println(find(arr));
    }
}
