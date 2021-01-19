package com.brian.test.fileIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: quan.chunyi
 * @date: 2018/8/29 下午4:23
 */
public class initMongoRepair {
    public static void main(String[] args) {
        //BufferedReader是可以按行读取文件
        String filePath = "/Users/momo/Desktop/patchLog1";
        FileInputStream inputStream = null;
        BufferedReader bufferedReader = null;
        Map<String, String> repairMap = new HashMap<>();

        try {
            inputStream = new FileInputStream(filePath);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                //分割
                int shardNum = Integer.valueOf(line.split("shardNum = ")[1].substring(0, 1));
                String hostPort = line.split("instance = ")[1].substring(0, 48).trim();
                hostPort = hostPort.split(",")[0];
                String lastId = line.split("\\|")[1];
                System.out.println(line);
                System.out.println("shardNum = " + shardNum + " hostPort = " + hostPort + " lastId = " + lastId);
                repairMap.put(hostPort, lastId);
            }
        } catch (Exception e) {

        }

        System.out.println(repairMap.size());
        System.out.println("----------------");
        System.out.println(repairMap);
    }
}
