package com.brian.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Arrays.asList()会返回一个List，List为Arrays中实现的内部类，对于List来讲没有add和remove方法
 * 实际上它是一个数组引用，因此修改一个另外一个也会更新。
 * 1. 对基本类型数组支持不好，看『一』
 * 2. 使用asList之后，数组和List会连接在一起，对一个更新另外一个会自动获得更新。（仅针对对象数组）
 * 3. asList得到的list是没有add和remove方法的
 */
public class asListTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        List list = Arrays.asList(arr);

        //一、对于基本类型，list的第一个元素会是数组引用，无法打印。
        foreach(list);

        //需要获取第一个元素并按照类型遍历
        foreachBase(list);

        //对于对象类型的数组，在asList之后可以正常输出
        Integer[] arr2 = new Integer[] {1,2,3,4};
        foreach(Arrays.asList(arr2));

        //list.set(0,5);会报错，但是修改原数组的话list也会获得相应的更新
        arr[0] = 5;
        foreachBase(list);
        foreach(arr);

        Map<hashKey, String> map = new HashMap<>();
        map.put(new hashKey(), "1");
    }

    private static void foreach(List list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    private static void foreach(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void foreachBase(List list) {
        int[] arr = (int[]) list.get(0);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static class hashKey {

    }

}
