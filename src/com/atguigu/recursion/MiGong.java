package com.atguigu.recursion;

import java.util.Arrays;

public class MiGong {
    public static void main(String[] args) {
        int[][] arr = new int[8][7];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 1;
            arr[i][6] = 1;
        }
        for (int j = 0; j < arr[0].length; j++) {
            arr[0][j] = 1;
            arr[7][j] = 1;
        }
        arr[3][1] = 1;
        arr[3][2] = 1;
        arr[2][2] = 1;
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        setWay(arr, 1, 1);
        System.out.println("迷宫路线为:");
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static boolean setWay(int[][] arr, int i, int j) {
        if (arr[6][4] == 2) {
            return true;
        }
        if (arr[i][j] == 0) {
            arr[i][j] = 2;
            if (setWay(arr, i + 1, j)) {//向下移动
                return true;
            } else if (setWay(arr, i - 1, j)) {//向上移动
                return true;
            } else if (setWay(arr, i, j + 1)) {//向右移动
                return true;
            } else if (setWay(arr, i, j - 1)) {//向左移动
                return true;
            } else {
                arr[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }

    }
}