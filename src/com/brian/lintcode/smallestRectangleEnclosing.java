package com.brian.lintcode;

/**
 * Created by briankwon on 2017/7/3.
 */
public class smallestRectangleEnclosing {

    public static int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return -1;
        }

        int width = image.length;
        int length = image[0].length;

        int left = findLeft(image, 0, y);
        int right = findRight(image, y, length - 1);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, width - 1);

        System.out.printf("left = %d\n", left);
        System.out.printf("right = %d\n", right);
        System.out.printf("top = %d\n", top);
        System.out.printf("bottom = %d\n", bottom);

        return (right - left + 1) * (bottom - top + 1);
    }

    public static int findLeft(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (!isEmptyColumn(image,mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (isEmptyColumn(image, start)) {
            return end;
        }

        return start;
    }

    public static int findRight(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (!isEmptyColumn(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (isEmptyColumn(image, end)) {
            return start;
        }

        return end;
    }

    public static int findTop(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (!isEmptyRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (isEmptyRow(image, start)) {
            return end;
        }

        return start;
    }

    public static int findBottom(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (!isEmptyRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (isEmptyRow(image, end)) {
            return start;
        }

        return end;
    }

    public static boolean isEmptyColumn(char[][] image, int col) {
        for (int i = 0; i < image.length; i++){
            if (image[i][col] == '1') {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmptyRow(char[][] image, int row) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[row][i] == '1') {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(minArea(new char[][] {{'0','0','1','0'}, {'0','1','1','0'}, {'0','1','0','0'}}, 0, 2));
    }
}
