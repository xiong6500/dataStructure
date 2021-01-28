package com.atguigu.search;

import java.util.Arrays;

/**
 * 斐波那契查找算法
 */
public class FibonacciSearch {
    public static int maxsize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int i = fibSearch(arr, 892);
        System.out.println(i);
    }

    //创建斐波那契额数组
    private static int[] fio() {
        int[] f = new int[maxsize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int fibSearch(int[] arr, int findVal) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int[] f = fio();
        while (high > f[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            int mid = low + f[k - 1] - 1;
            if (findVal < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (findVal > temp[mid]) {
                low = mid + 1;
                k -= 2;
            }else {
                if (mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
