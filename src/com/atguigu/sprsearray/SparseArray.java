package com.atguigu.sprsearray;

import java.util.Arrays;

public class SparseArray {
    public static void main(String[] args) {
        int[][] arr = new int[6][7];
        arr[0][3] = 22;
        arr[0][6] = 15;
        arr[1][1] = 11;
        arr[1][5] = 17;
        arr[2][3] = -6;
        arr[3][5] = 39;
        arr[4][0] = 91;
        arr[5][2] = 28;
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("-----------------------------");
        int[][] newArr = change(arr);
        for (int[] ints : newArr) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("-----------------------------------");
        int[][] reduction = reduction(newArr);
        for (int[] ints : reduction) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 稀疏数组转化为简单数组
     * @param tarr
     * @return
     */
    private static int[][] change(int[][] tarr) {
        int count = 0;
        for (int[] ints : tarr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    count++;
                }
            }
        }
        int[][] arr = new int[count + 1][3];
        arr[0][0] = tarr.length;
        arr[0][1] = tarr[0].length;
        arr[0][2] = count;
        int h = 1;
        for (int i = 0; i < tarr.length; i++) {
            for (int j = 0; j < tarr[i].length; j++) {
                if (tarr[i][j]!=0){
                    arr[h][0]=i;
                    arr[h][1]=j;
                    arr[h][2]=tarr[i][j];
                    h++;
                }
            }
        }

        return arr;
    }

    /**
     * 还原
     */
    private static int[][] reduction(int[][] change){
        int[][] arr = new int[change[0][0]][change[0][1]];
        for (int i=1;i<change.length;i++){
            arr[change[i][0]][change[i][1]]=change[i][2];
        }
        return arr;
    }
}
