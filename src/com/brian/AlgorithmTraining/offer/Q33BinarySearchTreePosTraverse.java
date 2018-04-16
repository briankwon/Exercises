package com.brian.AlgorithmTraining.offer;

public class Q33BinarySearchTreePosTraverse {
    public static void main(String[] args) {

    }

    public static boolean verity(int[] arr) {
        if (arr.length == 0) {
            return false;
        }

        if (arr.length == 1) {
            return true;
        }

        return verityRecur(arr, 0, arr.length - 1);
    }

    public static boolean verityRecur(int[] arr, int start, int end) {
        //递归的出口，当start和end相遇时递归结束，能到这个地步说明之前的都是二叉搜索树的后序遍历
        if (start >= end) {
            return true;
        }

        //搜索数组的前半部分，直到遇到一个元素大于等于根节点
        int i = start;
        for (; i < end; i++) {
            if (arr[i] >= arr[end]) {
                break;
            }
        }

        //此时i的值为数组后半部分开头的下标，搜索后半部分，如果有元素小于等于根节点，返回false
        for (int j = i; j < end; j++) {
            if (arr[j] <= arr[end]) {
                return false;
            }
        }

        //前后部分都符合二叉搜索树的定义，递归判断前后部分是否是二叉搜索树
        return verityRecur(arr, start, i - 1) && verityRecur(arr, i, end - 1);
    }
}
