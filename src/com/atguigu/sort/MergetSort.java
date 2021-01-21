package com.atguigu.sort;

import java.util.Arrays;

/**
 * 合并排序
 */
public class MergetSort {
    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    //分+合方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left<right){
            int mid = (left+right)/2;//中间索引
            mergeSort(arr,left,mid,temp);//向左递归进行分解
            mergeSort(arr,mid+1,right,temp);//向右递归进行分解
            merge(arr,left,mid,right,temp);//合并
        }
    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//初始化i,左边有序序列的初始索引
        int j = mid + 1;//初始化j,右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引
        //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
        // 即将左边的当前元素，填充到temp数组
        while (i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                temp[t] = arr[i];
                t+=1;
                i+=1;
            }else {
                temp[t] = arr[j];
                t+=1;
                j+=1;
            }
        }
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i<=mid){
            temp[t] = arr[i];
            t+=1;
            i+=1;
        }
        while (j<=right){
            temp[t] = arr[j];
            t+=1;
            j+=1;
        }
        //将temp数组的元素拷贝到arr
        // 注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }
    }

}
