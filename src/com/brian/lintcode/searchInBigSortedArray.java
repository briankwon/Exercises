package com.brian.lintcode;

/**
 * Created by briankwon on 2017/6/29.
 */
public class searchInBigSortedArray {
    public static int search(int[] nums, int target) {
        int index = 1;

        while (nums[index - 1] < target) {
            index = index * 2;
        }

        int start = (index - 1)/ 2;
        int end = index - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;

            if (target > nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,3,3,3,4,4,5,5,6,7,8,9,10,11,11,11,12,12,13,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14};
        System.out.println(search(nums, 14));
    }
}
