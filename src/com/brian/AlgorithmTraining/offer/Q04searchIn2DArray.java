package com.brian.AlgorithmTraining.offer;

public class Q04searchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {{2,6,8,11},{3,4,7,20},{6,21,33,200}};
        int row = 3;
        int col = 4;
        int target = 7;
        System.out.println(process(arr, target));
    }

    private static boolean process(int[][] arr, int target) {
        int row = arr.length;
        int col = arr[0].length;

        int start = 0;
        int end = row - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid][0] == target) {
                System.out.println(mid + " " + 0);
                return true;
            } else if (arr[mid][0] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        //这里容易出错
        //实际上是选最接近target的一个元素
        if (arr[end][0] <= target) {
            row = end;
        } else if (arr[start][0] <= target) {
            row = start;
        } else {
            return false;
        }

        start = 0;
        end = col - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid][row] == target) {
                System.out.println(mid + " " + row);
                return true;
            } else if (arr[mid][row] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (arr[start][row] == target) {
            System.out.println(start + " " + row);
            return true;
        }

        if (arr[end][row] == target) {
            System.out.println(end + " " + row);
            return true;
        }

        return false;
    }
}
