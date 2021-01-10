package com.atguigu.recursion;

import java.util.Arrays;

public class EightQueen {
    public static int[] arr;
    public static int count;

    public static void main(String[] args) {
        int max = 8;
        arr = new int[max];
        check(0,max);
        System.out.println("一共有"+count+"种解法");
    }

    /**
     * 放置第n+1个皇后
     * @param n
     */
    public static void check(int n,int max){
        if (n==max){
            //写一个方法,将皇后摆放的位置输出
            System.out.println(Arrays.toString(arr));
            count++;
            return;
        }
        for (int i=0;i<max;i++){
            arr[n] = i;
            if (isOk2(n)){
                check(n+1,max);
            }
        }
    }

    private static boolean isOk2(int k){
        for (int i=0;i<k;i++){//如果棋子在同一列
            if (arr[i]==arr[k]){
                return false;
            }
            if (arr[k]==arr[i]+k-i||arr[k]==arr[i]-(k-i)){//如果棋子在同一斜列
                return false;
            }
        }
        return true;
    }



}
