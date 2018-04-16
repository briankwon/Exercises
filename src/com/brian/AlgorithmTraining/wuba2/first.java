package com.brian.AlgorithmTraining.wuba2;

import java.util.*;

public class first {
    public static void main(String[] args) {
        String s = "asazzzsdde";
        System.out.println(process(s));
    }

    public static String process(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (entry.getValue() < 2) {
                iterator.remove();
            }
        }

        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        };

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, comparator);
        StringBuffer sb = new StringBuffer();

        for (Map.Entry<Character, Integer> entry : list) {
            sb.append(entry.getKey());
        }

        return sb.toString();
    }
}
