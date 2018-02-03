package com.brian.tool;

public class print {
    public void printArray(Object[] objs) {
        if (objs == null) {
            System.out.println("Obj is null");
        }

        for (Object obj : objs) {
            System.out.println(obj.toString() + " ");
        }
    }
}
