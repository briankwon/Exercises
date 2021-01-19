package com.brian.Hash;

import java.util.*;

/**
 * @author: quan.chunyi
 * @date: 2018/8/17 下午6:29
 */
public class IpHashing {
    public static String getRandomIp() {

        // ip范围
        int[][] range = { { 607649792, 608174079 }, // 36.56.0.0-36.63.255.255
                { 1038614528, 1039007743 }, // 61.232.0.0-61.237.255.255
                { 1783627776, 1784676351 }, // 106.80.0.0-106.95.255.255
                { 2035023872, 2035154943 }, // 121.76.0.0-121.77.255.255
                { 2078801920, 2079064063 }, // 123.232.0.0-123.235.255.255
                { -1950089216, -1948778497 }, // 139.196.0.0-139.215.255.255
                { -1425539072, -1425014785 }, // 171.8.0.0-171.15.255.255
                { -1236271104, -1235419137 }, // 182.80.0.0-182.92.255.255
                { -770113536, -768606209 }, // 210.25.0.0-210.47.255.255
                { -569376768, -564133889 }, // 222.16.0.0-222.95.255.255
        };

        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0] + new Random().nextInt(range[index][1] - range[index][0]));
        return ip;
    }

    /*
     * 将十进制转换成IP地址
     */
    public static String num2ip(int ip) {
        int[] b = new int[4];
        String x = "";
        b[0] = (int) ((ip >> 24) & 0xff);
        b[1] = (int) ((ip >> 16) & 0xff);
        b[2] = (int) ((ip >> 8) & 0xff);
        b[3] = (int) (ip & 0xff);
        x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);

        return x;
    }

    public static void main(String[] args) {
        int ipAmount = 100;
        int serverAmount = 10;
        Map<Integer, Integer> server = new HashMap<>(serverAmount);
        for (int i = 0; i < 10; i++) {
            server.put(i, 0);
        }

        Set<String> ipSet = new HashSet<>();

        for (int i = 0; i < ipAmount; i++) {
            String ip = getRandomIp();
            ipSet.add(ip);
            Integer key = (ip.hashCode() & 0x7fffffff) % 10;
            if (server.containsKey(key)) {
                server.put(key, server.get(key) + 1);
            } else {
                server.put(key, 1);
            }
        }

        System.out.println("---------IP AMOUNT = 100000--------");

        System.out.println(server);

        Set<String> set = new HashSet<>();
        Set<Integer> hashSet = new HashSet<>();
        System.out.println("123.233.101.140".hashCode() & 0x7fffffff);
        System.out.println("139.215.26.97".hashCode() & 0x7fffffff);

        int i = 0;
        while (i < 100) {
            String key = getRandomIp();
            if (!set.contains(key)) {
                set.add(key);
                int hashKey = (key.hashCode() & 0x7fffffff);
                if (hashSet.contains(hashKey)) {
                    System.out.println("find dupulication, key = " + key);
                } else {
                    hashSet.add(hashKey);
                }
            }
            i++;
        }

//        System.out.println("---------重复率统计--------");
//        Map<Integer, Integer> statics = new HashMap<>();
//
//        for (Integer ip : ipSet) {
//            Integer key = Math.abs(ip.hashCode()) % 10;
//            if (statics.containsKey(ip)) {
//                statics.put(ip, statics.get(ip) + 1);
//            } else {
//                statics.put(ip, 1);
//            }
//        }
//
//        int count = 0;
//        for (Map.Entry<String, Integer> entry : statics.entrySet()) {
//            if (entry.getValue() > 1) {
//                count++;
//            }
//        }
//
//        System.out.println("count = " + count);
    }

}
