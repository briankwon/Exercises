package com.brian.sort;
/**
 *  已知一个整型数组arr，数组长度为size且size大于2，arr有size-1种 可以划分成左右两部分的方案。
    比如:
    arr = {3, 2, 3, 4, 1, 2}
    第1种划分左部分为[3]，右部分为[2, 3, 4, 1, 2] 第2种划分左部分为[3, 2]，右部分为[3, 4, 1, 2] 第3种划分左部分为[3, 2, 3]，右部分为[4, 1, 2] 第4种划分左部分为[3, 2, 3, 4]，右部分为[1, 2] 第5种划分左部分为[3, 2, 3, 4, 1]，右部分为[2]
    每一种划分下，左部分都有最大值记为max_left，右部分都有最大值记 为max_right。 求|max_left-max_right|(左部分最大值与左部分最大值之差的绝对值)， 最大是多少?
    要求:时间复杂度为O(N)，额外空间复杂度O(1)。
 */

public class seminarII {
    public static void process(int[] arr) {
        int[] leftHelp = new int[arr.length];
        leftHelp[0] = arr[0];

        int[] rightHelp = new int[arr.length];
        rightHelp[arr.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            leftHelp[i] = arr[i] > leftHelp[i - 1] ?  arr[i] : leftHelp[i - 1];
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            rightHelp[i] = arr[i] > rightHelp[i + 1] ? arr[i] : rightHelp[i + 1];
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = Math.abs(leftHelp[i] - rightHelp[i]);
            max = temp > max ? temp : max;
        }

        System.out.println(max);
    }
    public static void main(String[] args) {
        int[] arr = {3,5,34,1,32,75,7,43};
        process(arr);
    }
}
