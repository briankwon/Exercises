package com.brian.test;

import java.util.*;

public class arraySetListMapConvert {
    public static void main (String[] args) {
        map2List();
    }

    private static void map2List () {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("brian", "kwon");
//        map.put("kevin", "johnson");
//        map.put("lebron", "james");
//
//        List<String> keyList = new ArrayList<String>(map.keySet());
//        System.out.println(keyList);
//
//        List<String> valueList = new ArrayList<String>(map.values());
//        System.out.println(valueList);
//        String[] arr = new String[valueList.size()];
//        valueList.toArray(arr);
//        for (String str : arr) {
//            System.out.println(str);
//        }
        Queue<String> queue = new LinkedList<>();
        Queue<String> queue1 = new PriorityQueue<>();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("语文", 1);
        map.put("数学", 2);
        map.put("英语", 3);
        map.put("历史", 4);
        map.put("政治", 5);
        map.put("地理", 6);
        map.put("生物", 7);
        map.put("化学", 8);
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
