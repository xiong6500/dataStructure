package com.atguigu.queue;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQueueTest {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用户收入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接受一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.push(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.pull();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("头数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("已经退出");
                    loop=false;
                    break;
            }
        }
    }

}

class ArrayQueue {
    private int[] arr;
    private int rear;
    private int front;


    public ArrayQueue(int maxSize){
        this.arr = new int[maxSize];
        this.rear = -1;
        this.front = -1;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public boolean isFull(){
        return rear==arr.length-1;
    }

    public void showQueue(){
        System.out.println(Arrays.toString(arr));
    }

    public void push(int num){
        if (isFull()){
            System.out.println("队列已经满了,请清除后再添加");
        }else {
            arr[++rear]=num;
        }
    }

    public int pull(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,无法取出数据");
        }else {
            return arr[++front];
        }
    }

    public int headQueue(){
        return arr[0];
    }
}
