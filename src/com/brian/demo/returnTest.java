package com.brian.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: quan.chunyi
 * @date: 2018/8/10 下午12:21
 */
public class returnTest {
    public static void main(String[] args) {
        System.out.println(get());
    }

    public static String get() {
        Map<String, String> map = new HashMap<>();
        return map.get("kk");
    }
}
