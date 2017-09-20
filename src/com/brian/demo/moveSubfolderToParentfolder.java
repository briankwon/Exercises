package com.brian.demo;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class moveSubfolderToParentfolder {
    private static String base;
    private static String imgPattern = "(.jpg|.jpeg|.png|.bmp|.gif)$";

    private boolean legalName (File file) {
        Pattern p = Pattern.compile(imgPattern);
        Matcher m = p.matcher(String.valueOf(file));
        return m.find();
    }

    private void traverseCopyFolder(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                traverseCopyFolder(String.valueOf(f));
            } else if (f.isHidden()) {
                System.out.println("find .DS_Store at " + f);
            } else {
                String dirName = f.getParent();//最深层文件所在文件夹
                File src = new File(dirName);
                File des = new File(base + "/" + src.getName());
                des.mkdir();//建立目标文件夹

                File[] pics = src.listFiles();
                for (File pic : pics) {
                    try {
                        InputStream in = new FileInputStream(pic);
                        String[] picName = String.valueOf(pic).split("/");
                        OutputStream out = new FileOutputStream(des + "/" + picName[picName.length - 1]);
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
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Give a path");
            }
            base = args[0];
            new moveSubfolderToParentfolder().traverseCopyFolder(args[0]);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
