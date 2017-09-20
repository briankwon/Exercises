package com.brian.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class arraySetListMapConvert {
    public static void main (String[] args) {
        map2List();
    }

    private static void map2List () {
        Map<String, String> map = new HashMap<String, String>();
        map.put("brian", "kwon");
        map.put("kevin", "johnson");
        map.put("lebron", "james");

        List<String> keyList = new ArrayList<String>(map.keySet());
        System.out.println(keyList);

        List<String> valueList = new ArrayList<String>(map.values());
        System.out.println(valueList);
        String[] arr = new String[valueList.size()];
        valueList.toArray(arr);
        for (String str : arr) {
            System.out.println(str);
        }
    }
}
