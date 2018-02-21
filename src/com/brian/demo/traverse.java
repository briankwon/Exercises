package com.brian.demo;


import java.util.*;

public class traverse {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        Map<String, Integer> map1 = new LinkedHashMap<>();

        for (int i = 0; i < 10; i++) {
            map1.put(i + "", i);
        }

        for (String key : map1.keySet()) {
            System.out.println(map1.get(key));
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {

        }

        for (int i = 0; i < 10; i++) {
            map.put(i + "", new Random().nextInt(10000));
            set.add(new Random().nextInt(999));
        }

        Iterator<Map.Entry<String, Integer>> itmap = map.entrySet().iterator();
        while (itmap.hasNext()) {
            Map.Entry<String, Integer> entry = itmap.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key = " + key + " value = " + value);
        }

        for (String key : map.keySet()) {
            System.out.println("key = " + key);
        }

        for (Integer num : map.values()) {
            System.out.println("value = " + num);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }

        Iterator<Map.Entry<String, Integer>> iterators = map.entrySet().iterator();

        while (iterators.hasNext()) {
            Map.Entry<String, Integer> it = iterators.next();
            System.out.println("key = " + it.getKey() + " value = " + it.getValue());
        }

        for (Integer num : set) {
            System.out.println(num);
        }

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println("num = " + it.next());
        }

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < 100; i++) {
            treeSet.add(new Random().nextInt(999));
        }

        for (Integer num : treeSet) {
            System.out.println(num);
        }

        Iterator<Integer> itTree = treeSet.iterator();
        while (itTree.hasNext()) {
            System.out.println(itTree.next());
        }
    }
}
