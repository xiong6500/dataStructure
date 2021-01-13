package com.atguigu.sort;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1, -1, 89};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);//生成一个[0,8000000)数
        }
        long start = System.currentTimeMillis();
        insertSort2(arr);
        long end = System.currentTimeMillis();
        System.out.println("排序所用时间为:" + (end - start));
//        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            for (int j=i;j>0;j--){
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    private static void insertSort2(int[] arr){
        int insertVal = 0;//要插入的值
        int insertIndex = 0;//要插入的位置
        for (int i=1;i<arr.length;i++){
            insertIndex = i;
            insertVal = arr[i];
            while (insertIndex>0&&insertVal<arr[insertIndex-1]){
                arr[insertIndex] = arr[insertIndex-1];
                insertIndex--;
            }
            if (insertIndex!=i){
                arr[insertIndex] = insertVal;
            }
        }
    }
}
