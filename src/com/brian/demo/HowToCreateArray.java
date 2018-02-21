package com.brian.demo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by briankwon on 2017/3/24.
 */
public class HowToCreateArray {
    public static void main(String[] args) {
        List<String> list =  new LinkedList<>();
        list.add("First");
        list.add("SECOND");
        list.add("THIRD");
        list.add("FOURTH");
        System.out.println(list.size());
        list.add("fifth");
        list.add("sixth");
        list.add("sixth");
        list.add("sixth");
        list.add("sixth");
        list.add("sixth");
        list.add("sixth");
        list.add("sixth");
        list.add("sixth");
        System.out.println("after adding a new element, size = " + list.size());

    }

}
