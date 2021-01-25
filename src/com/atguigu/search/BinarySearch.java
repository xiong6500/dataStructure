package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        /*int index = binarySort(arr, 0, arr.length - 1, 1);
        if (index != -1) {
            System.out.println(index);
        } else {
            System.out.println("索引不存在");
        }*/
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1234);
        if (list.size() > 0) {
            System.out.println(list);
        }else {
            System.out.println("索引不存在");
        }
    }

    private static int binarySort(int[] arr, int left, int right, int val) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (val < arr[mid]) {
                return binarySort(arr, left, mid - 1, val);
            } else if (val > arr[mid]) {
                return binarySort(arr, mid + 1, right, val);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }

    private static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        if (findVal > arr[mid]) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(mid);
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp--);
            }
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp++);
            }
            return list;
        }
    }
}