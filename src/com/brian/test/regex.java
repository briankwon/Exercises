package com.brian.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    private static String pattern = "(?=^.{6,25}$)(?=(?:.*?\\d){2})(?=.*[a-z])(?=(?:.*?[A-Z]){1})[0-9a-zA-Z!@#$%*()_+^&]*$";
    private static String pw = "11111abC";
    private static String IMAGE_FILE_EXTENSION = ".*(.png|.bmp|.jpg|.jpeg|.PNG|.BMP|.JPG|.JPEG)$";
    private static String[] IMAGE_FILE_EXT = new String[] {"png", "jpg", "gif", "jpeg"};
    private static Set<String> extension = new HashSet<String>();

    public static boolean isFileAllowed (String fileName) {
        return fileName.matches(IMAGE_FILE_EXTENSION);
    }

    public static void main(String[] args) {

        String s = "abc.jpg";
        //String regex=".+?//.(.+)";这种写法也是可以的，但我认为没有后面的精确
        String regex=".+?//.([a-zA-z]+)";
        Pattern pt = Pattern.compile(regex);
        Matcher mt = pt.matcher(s);
        if(mt.find()) {
            System.out.println(mt.group(1));
        } else {
            System.out.println("unlucky");
        }

        System.out.println(pw.matches(pattern));
        System.out.println(isFileAllowed("di.PNG"));

        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));

        String file = "alnd.adse.jpg";
        int dotPos = file.lastIndexOf('.');
        String ext = file.substring(dotPos + 1);

        System.out.println(file.substring(file.lastIndexOf('.')));

        for (int i = 0; i < IMAGE_FILE_EXT.length; i++) {
            extension.add(IMAGE_FILE_EXT[i]);
        }

        for (String str: extension) {
            System.out.println(str);
        }

        Iterator<String> itr = extension.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        for (String imageExt: IMAGE_FILE_EXT) {
            if (imageExt.equals(ext)) {
                //return true;
            }

            //return false;
        }



    }
}
