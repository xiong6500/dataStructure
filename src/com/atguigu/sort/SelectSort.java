package com.atguigu.sort;

public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//生成一个[0,8000000)数
        }
        long start = System.currentTimeMillis();
        selectSort(arr);
        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));
        long end = System.currentTimeMillis();
        System.out.println("排序所用时间为:" + (end - start));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int h = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min =arr[j];
                    h = j;
                }
            }
            if (h!=i){
                arr[h] = arr[i];
                arr[i] = min;
            }
        }
    }
}
