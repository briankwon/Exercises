package com.brian.lintcode;

/**
 * Created by briankwon on 2017/7/3.
 */
public class findMinimumInRotatedSortedArrayI {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int target = nums[nums.length - 1];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //if(num[mid] > num[end]) 你是可以确定最小值就在右边区域. 否则就在左边区域.
            //但是 如果你用mid 和 start 比较, 比如你这样 if(num[mid] > num[start]) 这样的比较,没法确定到底答案在哪个半区.
            //这么比较是没有意义的.
            if (target >= nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }

//        System.out.println(nums[start]);
//        System.out.println(nums[end]);
        // 假如sorted array并没有被排序的话，最终剩下的start和end会是相邻的而且nums[end] > nums[start]，这种情况下如果把等与判断给了nums[end]就错了。
        // 其实不把等于判断给"nums[start] <= target"也没关系，但是一定不能给nums[end]，如果拎出来再写个判断的话没有必要，因此整合进了"nums[start] <= target"中。
        if (nums[start] <= target) {
            return nums[start];
        } else {
            return nums[end];
        }
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {5,6,7,0,1,2,3,4}));
    }
}
