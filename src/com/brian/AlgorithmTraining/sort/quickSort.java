package com.brian.AlgorithmTraining.sort;

public class quickSort {
    public static void sort(int[] arr, int L, int R) {
        if (arr == null || arr.length == 0) {
            return;
        }

        //arr= [1,2,3,4,5,6,7]，在这种情况下partition后sort的下半部分传入的参数会是[7，6]，需要(L < R)的判断来跳过这种情况
        if (L < R) {
            //小于5时直接插入排序
            if (R - L + 1 < 5) {
                insertSort(arr, L, R);
                return;
            }
            //从数组中[L, R]的范围内随机选择一个数和最后一个数交换作为划分值，避免了arr[R]如果选不好造成整体性能差的问题
            //注意要加上L
            swap(arr, L + (int) Math.random() * (R - L + 1), R);
            int[] p = partition(arr, L, R);
            sort(arr, L, --p[0]);
            sort(arr, ++p[1], R);
        }
    }

    public static void insertSort(int[] arr, int L, int R) {
        for (int i = L + 1; i <= R; i++) {
            for (int j = i - 1; j >= L; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    //只有左区间
    public static void partition1(int[] arr, int L, int R) {
        int index = L - 1;
        for (int i = L; i <= R; i++) {
            if (arr[i] <= arr[R]) {
                swap(arr, i, ++index);
            }
        }
        System.out.println(index);
    }

    //左右区间同时向中间逼近，返回中间被比较值所在的区间范围
    //arr[R]为被比较值，arr[L]为移动值
    public static int[] partition(int[] arr, int L, int R) {
        int leftIndex = L - 1;
        int rightIndex = R;

        //这里不能有等号，跑一遍[3,2,0,5,6,4]试试就知道了
        //当arr[L] < arr[R]时，每次是左区间右边的数字和L上的数字换位置，如果L <= rightIndex的话就会变成左区间右边的数字和右区间左边界位置上的数字换位置，乱套了
        while (L < rightIndex) {
            if (arr[L] < arr[R]) {
                swap(arr, ++leftIndex, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, L , --rightIndex);
            } else {
                L++;
            }
        }
        //将被比较值[R]换到右区域的最左侧
        swap(arr, R, rightIndex);
        //返回中间相同的数的左边界和右边界，注意这里rightIndex不用-1，因为在上一步中已经把右区间中的第一个数和我们的比较值arr[R]进行了交换，
        //此时rightIndex指向的就是被比较值
        return new int[] {leftIndex + 1, rightIndex};
    }

    //和上面一样，但是新建一个变量mid表示被比较值，这样最后不用交换右区间的第一个数和最后一个数(也就是被比较数)
    public static int[] partition2(int[] arr, int L, int R) {
        int leftIndex = L - 1;
        int rightIndex = R + 1;
        int pivot = arr[R];

        while (L < rightIndex) {
            if (arr[L] < pivot) {
                swap(arr, ++leftIndex, L++);
            } else if (arr[L] > pivot) {
                swap(arr, L , --rightIndex);
            } else {
                L++;
            }
        }

        return new int[] {leftIndex + 1, rightIndex - 1};
    }

    //只返回比较值的下标
    //input : arr[3,2,1,4,0,6,4] -> arr[3,2,1,4,0,4,6]
    //output: 5
    public static int partition4(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }

        int pos = R;
        //和左神的方法一样，避开比较值的位置，从前一位开始比较，最后再将比较值和右区间左边界互换。
        R--;

        while (L <= R) {
            while (L < pos && arr[L] <= arr[pos]) {
                L++;
            }

            while (R > L && arr[R] > arr[pos]) {
                R--;
            }

            if (L >= R) {
                break;
            }

            swap(arr, L, R);
        }

        swap(arr, L, pos);
        return L;
    }

    public static void sort4(int[] arr, int L, int R) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (L < R) {
            int pos = partition4(arr, L, R);
            sort4(arr, L, pos - 1);
            sort4(arr, pos + 1, R);
        }
    }


    public static void swap(int[] arr, int a ,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {2,3,6,845,4,12,34,34,5,65,67,758,5,432,4,21,12,89,45,6,87,34,65,546,8,89};
        int[] arr1 = {3,4,5,0,6,4};
        int[] arr2 = {3,2,1,4,0,6,4};

        sort(arr, 0, arr.length - 1);

        for (int ele : arr) {
            System.out.print(ele + " ");
        }

        System.out.println(" ");
        partition(arr, 0, arr.length - 1);
    }
}
