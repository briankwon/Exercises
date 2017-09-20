package com.brian.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by briankwon on 2017/3/24.
 */
public class NewWorld {
    public static void main(String[] args) {
        List<String> list =  new ArrayList<String>();
        list.add("First");
        list.add("SECOND");
        list.add("THIRD");
        list.add("FOURTH");
        System.out.println(list);

        String[] array = new String[] {"FIRST", "SECOND", "THIRD", "FOURTH"};
        System.out.println(Arrays.toString(array));

        String[] arr1 = new String[] {"FIFTH", "SIXTH"};
        List<List<String>> myList = new ArrayList<List<String>>();
        String name = "brian";
        System.out.println(name.length());
    }

}
