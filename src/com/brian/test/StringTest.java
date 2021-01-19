package com.brian.test;

import java.util.HashMap;
import java.util.Map;

public class StringTest {
    public static void main(String[] args) {
        String s = new String("hello");
        String s2 = s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");

        String s4 = "11";
        System.out.println(s3 == s4);


        System.out.println("------------");
        Map<String, Object> map = new HashMap<>();
        map.put("brian", "kwon");
        String str = (String) map.get("bb");
    }
}
