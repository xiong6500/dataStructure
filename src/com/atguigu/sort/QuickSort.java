package com.atguigu.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right) {
        int l = left;
        int r = right;
        //中轴值
        int pivort = arr[(left+right)/2];
        int temp = 0;
        while (l<r){
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l]<pivort){
                l+=1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出

            while (arr[r]>pivort){
                r-=1;
            }
            //如果l>=r说明pivot的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l>=r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l]==pivot值相等r--，前移避免重复
            if (arr[l]==pivort){
                r-=1;
            }
            //如果交换完后，发现这个arr[r]==pivot值相等l++，后移避免重复
            if (arr[r]==pivort){
                l+=1;
            }
        }
        //如果l==r,必须l++,r--,否则为出现栈溢出
        if(l==r){
            l+=1;
            r-=1;
        }
        //向左递归
        if (left<r){
            quickSort(arr,left,r);
        }
        if (right>l){
            quickSort(arr,l,right);
        }
    }
}
