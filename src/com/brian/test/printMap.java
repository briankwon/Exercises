package com.brian.test;

import java.util.*;

public class printMap {
    public static void main (String[] args) {
        printMap example = new printMap();
        String name = "Brian";
        String age = "24";
        String school = "skku";
        Map<String, String> info = new HashMap<String, String>();
        info.put("name", name);
        info.put("age", age);
        info.put("school", school);
        example.go(info);
        example.iterateMap(info);
    }

    public void go (Map<String, String> source) {
        Set set = source.entrySet();
        Map.Entry[] entries = (Map.Entry[])set.toArray(new Map.Entry[set.size()]);
        for (int i = 0; i < entries.length; i++) {
            System.out.println("key = " + entries[i].getKey().toString());
            System.out.println("value = " + entries[i].getValue().toString());
        }
    }

    public void iterateMap (Map<String, String> x) {
        Collection collection = x.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
