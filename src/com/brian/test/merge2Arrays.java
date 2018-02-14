package com.brian.test;

import java.util.HashSet;
import java.util.Set;

public class merge2Arrays {
//    public static void main(String[] args) {
//        int[] a = {1, 2, 2, 3, 7, 7, 3, 20, 21};
//        int[] b = {1, 2, 4, 8, 43, 8, 9, 4, 2, 1, 21};
//        hashsetMerge(a, b);
//        hashmapMerge(a, b);
//    }
//
//    public static void hashsetMerge (int[] a, int[] b) {
//        Set<Integer> result = new HashSet<Integer>();
//
//        for (int i = 0; i < a.length; i++) {
//            result.add(a[i]);
//        }
//
//        for (int i = 0; i < b.length; i++) {
//            result.add(b[i]);
//        }
//
//        Integer[] finalResult = new Integer[result.size()];
//        result.toArray(finalResult);
//        for (int i = 0; i < finalResult.length; i++) {
//            System.out.println(finalResult[i] + " ");
//        }
//    }
//
//    public static void hashmapMerge (int[] a, int[] b) {
//    }
      public static void main (String[] args) {
//          Map map=new HashMap();
//          Integer[] arrN={1,2,3,4,5,6,7,8,9};
//          Integer[] arrM={1,1,12,3,2,5,9,1};
//          for(int i=0;i<arrN.length;i++){
//              map.put(""+arrN[i], arrN[i]);
//          }
//          for(int j=0;j<arrM.length;j++){
//              if(map.get(""+arrM[j])!=null){
//                  System.out.println("相同的元素有"+arrM[j]);
//              }
//          }
          Set<Integer> set = new HashSet<>();

          int[] arr1 = {1,2,3,4,5,6,7,8,9};
          int[] arr2 = {1,1,12,3,2,5,9,1};
          for (int num : arr1) {
              set.add(num);
          }

          for (int num : arr2) {
              if (set.contains(num)) {
                  System.out.println("same element : " + num);
              }
          }

      }
}
