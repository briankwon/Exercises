package com.brian.demo;

import java.io.*;

public class regexTest {
    public static void main (String[] args) {
        String picPath = "/Users/briankwon/Downloads/Quan/hei/8月/170801/1/giri_sisters_fullcolor_vandp_eng_123.png";
        String des = "/Users/briankwon/Downloads/Quan/hei/8月/";
        File desPath = new File(des + "copy.png");

        String[] picName = picPath.split("/");
        System.out.println(picName[picName.length - 1]);

        try {
            InputStream in = new FileInputStream(picPath);
            OutputStream out = new FileOutputStream(desPath);

            byte[] buffer = new byte[1024];
            int flag;
            while ((flag = in.read(buffer)) != -1) {
                out.write(buffer, 0, flag);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            //
        }
    }
}
