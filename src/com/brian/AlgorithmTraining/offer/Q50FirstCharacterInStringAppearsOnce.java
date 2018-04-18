package com.brian.AlgorithmTraining.offer;

import java.util.HashMap;
import java.util.Map;

public class Q50FirstCharacterInStringAppearsOnce {
    public static void main(String[] args) {
        String s = "aabbccddeffghaon";
        System.out.println(search(s));
    }

    public static int search(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
