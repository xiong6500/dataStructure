package com.atguigu.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 用程序给出随便大小的10 个数，序号为1-10，按从小到大顺序输出，并输出相应的序号
 */
public class OrderTest1 {
    public static void main(String[] args) {
        Random random = new Random();
        List list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(random.nextInt(1000));
        }
        Collections.sort(list);//对集合中的元素进行排序
        for (Object o : list) {
            System.out.print(o+" ");
        }
        System.out.println("你好123");
        System.out.println("你好22226");
    }
}
