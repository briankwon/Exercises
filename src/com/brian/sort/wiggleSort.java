package com.brian.sort;

import java.util.Arrays;

public class wiggleSort {
    public static void wiggleSort(int[] nums) {
        // write your code here
        Arrays.sort(nums);

        for (int i = 1; i < nums.length - 1; i += 2) {
            int temp = nums[i + 1];
            nums[i + 1] = nums[i];
            nums[i] = temp;
        }

        for(int num: nums) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        wiggleSort(new int[] {3,5,2,1,6,4});
    }
}
