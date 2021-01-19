package com.brian.JDK8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: quan.chunyi
 * @date: 2018/9/5 下午4:01
 */
public class iterateForeach {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.forEach(num->{
            System.out.println(num);
        });
    }
}
