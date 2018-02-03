package com.brian.lintcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class outputRepeatedEleInTwoArrays {
    public static void main (String[] args) {
        int[] m = {1,2,3,4,5,6,7};
        int[] n = {2,6,4};
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; i < m.length; i++) {
            map.put(String.valueOf(m[i]), 0);
        }

        for (int i = 0; i < n.length; i++) {
            boolean isIn = map.containsKey(String.valueOf(n[i]));
            if (isIn) {
                int temp = (int)map.get(String.valueOf(n[i]));
                map.put(String.valueOf(n[i]), temp + 1);
            } else {
                map.put(String.valueOf(n[i]), 0);
            }
        }

        System.out.println(map.toString());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if ((int)entry.getValue() != 0) {
                System.out.println(entry.getKey());
            }
        }

        Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Object> entry = entries.next();
            if ((int)entry.getValue() != 0) {
                System.out.println(entry.getKey());
            }
        }
    }
}
