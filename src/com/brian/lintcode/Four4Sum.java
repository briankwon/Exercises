package com.brian.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four4Sum {
    public static void main(String[] args) {
        int[] arr = new int[] {21, 88, 2, 63, 6, 40, 46, 40, 34, 54, 43, 34, 41, 78, 84, 68, 93, 48, 81, 66, 78, 15, 86, 8, 91, 4, 90, 60, 58, 84, 83, 3, 54, 46, 85, 66, 65, 70, 75, 22, 62, 29, 17, 26, 18, 5, 7, 23, 36, 60, 92, 82, 30, 41, 26, 68, 22, 86, 4, 76, 89, 62, 90, 67, 94, 26, 71, 99, 76, 83, 40, 40, 84, 25, 13, 7, 93, 30, 22, 17, 19, 53, 11, 88, 35, 51, 44, 78, 10, 42, 92, 33, 96, 7, 81, 83, 8, 42, 25, 24};
        List<List<Integer>> res = fourSum(arr, 142);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<List<Integer>> fourSum(int[] arr, int s) {
        if (arr == null || arr.length < 4) {
            return null;
        }

        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j]) {
                    continue;
                }
                int m = j + 1;
                int n = arr.length - 1;

                while (m < n) {
                    int sum = arr[i] + arr[j] + arr[m] + arr[n];
                    if (sum == s) {
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(i);
                        tuple.add(j);
                        tuple.add(m);
                        tuple.add(n);
                        m++;
                        n--;
                        if (!res.contains(tuple)) {
                            res.add(tuple);
                        }

                        while (m < n && arr[m] == arr[m - 1]) {
                            m++;
                        }

                        while (m < n && arr[n] == arr[n + 1]) {
                            n--;
                        }
                    } else if (sum < s) {
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }

        return res;
    }
}
