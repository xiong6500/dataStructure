package com.atguigu.search;

public class SepSearch {
    public static void main(String[] args) {
        int[] arr = {1,9,11,-1,34,89};
        int index = seqSearch(arr,34);
        if (index!=-1){
            System.out.println(index);
        }else {
            System.out.println("索引不存在");
        }

    }

    private static int seqSearch(int[] arr, int val) {
        for (int i=0;i<arr.length;i++){
            if (arr[i]==val){
                return i;
            }
        }
        return -1;
    }
}
