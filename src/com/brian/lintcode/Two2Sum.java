package com.brian.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Two2Sum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
        //int[] res = TwoSum(arr, 14);
        int[] res = ThreeSum(arr, 17);

        for (int num : res) {
            System.out.println(num);
        }

        System.out.println("求出所有的2SUM版本");
        List<List<Integer>> result = new ArrayList<>();
        twoSum(arr, 15, result);
        Iterator<List<Integer>> iterator = result.iterator();

        while (iterator.hasNext()) {
            List<Integer> list = iterator.next();
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("求出所有的3SUM版本");
        List<List<Integer>> result3sum = threeSum(arr, 19);
        Iterator<List<Integer>> iterator1 = result3sum.iterator();

        while (iterator1.hasNext()) {
            List<Integer> list = iterator1.next();
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    /**
     * 双指针
     * @param arr
     * @param s
     * @return
     */
    public static int[] TwoSum(int[] arr, int s) {
        if (arr == null || arr.length < 2) {
            return null;
        }

        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;

        while  (i < j) {
            int temp = arr[i] + arr[j];
            if (temp < s) {
                i++;
            } else if (temp > s) {
                j--;
            } else {
                return new int[] {i, j};
            }
        }

        return null;
    }

    /**
     * 求出所有的twoSum
     * @param arr
     * @param s
     * @param list
     */
    public static void twoSum(int[] arr, int s, List<List<Integer>> list) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int temp = arr[i] + arr[j];
            if (temp == s) {
                List<Integer> tuple = new ArrayList<>();
                tuple.add(i);
                tuple.add(j);
                list.add(tuple);
                i++;
                j--;

                while (i < j && arr[i] == arr[i - 1]) {
                    i++;
                }

                while (i < j && arr[j] == arr[j + 1]) {
                    j--;
                }
            } else if (temp > s) {
                j--;
            } else {
                i++;
            }
        }
    }

    /**
     * 3Sum问题，从0~arr.length-1依次去数字，接着就变成了2Sum问题。
     * 注意在2Sum中不用判断i/j = k的情况，直接跳过
     * @param arr
     * @param s
     * @return
     */
    public static int[] ThreeSum(int[] arr, int s) {
        if (arr == null || arr.length < 3) {
            return new int[] {-1};
        }

        Arrays.sort(arr);

        for (int k = 0; k < arr.length - 1; k++) {
            int sub = s - arr[k];
            int[] twoSum = TwoSumModified(arr, sub, k);

            if (twoSum != null) {
                int[] res = Arrays.copyOf(twoSum, 3);
                res[2] = k;
                Arrays.sort(res);
                return res;
            }
        }

        return null;
    }

    public static int[] TwoSumModified(int[] arr, int s, int k) {
        int i = k + 1;
        int j = arr.length - 1;

        while  (i < j) {
            int temp = arr[i] + arr[j];
            if (temp < s) {
                i++;
            } else if (temp > s) {
                j--;
            } else {
                return new int[] {i, j};
            }
        }

        return null;
    }

    /**
     * 找出所有的threeSum
     * @param arr
     * @param s
     */
    public static List<List<Integer>> threeSum(int[] arr, int s) {
        if (arr == null || arr.length < 3) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for (int k = 0; k < arr.length - 2; k++) {
            //跳过重复的值
            if (k > 0 && arr[k] == arr[k - 1]) {
                continue;
            }

            twoSumModified(arr, s - arr[k], k, result);
        }

        return result;
    }

    public static void twoSumModified(int[] arr, int s,int k, List<List<Integer>> list) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int i = k + 1;
        int j = arr.length - 1;

        while (i < j) {
            int temp = arr[i] + arr[j];
            if (temp == s) {
                List<Integer> tuple = new ArrayList<>();
                tuple.add(i);
                tuple.add(j);
                tuple.add(k);
                list.add(tuple);
                i++;
                j--;

                while (i < j && arr[i] == arr[i - 1]) {
                    i++;
                }

                while (i < j && arr[j] == arr[j + 1]) {
                    j--;
                }
            } else if (temp > s) {
                j--;
            } else {
                i++;
            }
        }
    }
}
