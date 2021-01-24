package com.atguigu.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        //定义一个最大值,找出它
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();//最大长度
        //定义一个二维数组,表示10个桶,每个桶就是一个一维数组
        //说明
        //1.二维数组包含10个一维数组/
        // /2.为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        // 3.名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据,
        // 我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0],记录的就是bucket[0]桶的放入数据个数
        int[] bucketElementCounts = new int[10];
        //这里我们使用循环将代码处理
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)，第一次是个位，第二次是十位，第三次是百位.
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitElement = arr[j] / n % 10;
                //放入对应的桶中
                bucket[digitElement][bucketElementCounts[digitElement]] = arr[j];
                bucketElementCounts[digitElement]++;
            }
            //遍历每一个桶
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                //循环该桶即第k个桶(即第k个一维数组),放入
                if (bucketElementCounts[k] != 0) {
                    for (int h = 0; h < bucketElementCounts[k]; h++) {
                        arr[index] = bucket[k][h];
                        index++;
                    }
                }
                //第i+1轮处理后，需要将每个bucketElementCounts[k]=0！！！
                bucketElementCounts[k] = 0;
            }
        }

    }
}
