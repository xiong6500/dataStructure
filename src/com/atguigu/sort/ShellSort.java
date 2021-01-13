package com.atguigu.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        System.out.println(9 / 2);
        shellSort3(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i; j < arr.length; j += gap) {
                    for (int h = j; h >= gap; h -= gap) {
                        if (arr[h] < arr[h - gap]) {
                            int temp = arr[h];
                            arr[h] = arr[h - gap];
                            arr[h - gap] = temp;
                        }
                    }
                }
            }
        }


    }

    private static void shellSort2(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i=gap;i<arr.length;i++){
                int val = arr[i];
                int index = i;
                if (arr[index]<arr[index-gap]){
                    while (index-gap>=0&&val<arr[index-gap]){
                        arr[index] = arr[index-gap];
                        index = index-gap;
                    }
                    if (index!=i){
                        arr[index] = val;
                    }
                }
            }
        }
    }

    private static void shellSort3(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = arr.length-gap-1; i >=0; i--) {
                int val = arr[i];
                int index = i;
                if (arr[index+gap]<arr[index]){
                    while (index+gap<arr.length&&val>arr[index+gap]){
                        arr[index] = arr[index+gap];
                        index += gap;
                    }
                    if (index!=i){
                        arr[index] = val;
                    }
                }
            }
        }


    }
}
