package com.atguigu.queue;

import java.util.Scanner;

public class CircleQueueTest {
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(3);
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
                    circleQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    circleQueue.push(value);
                    break;
                case 'g':
                    try {
                        int res = circleQueue.pull();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleQueue.headQueue();
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

class CircleQueue {
    private int[] arr;
    private int maxSize;
    //rear的默认值是0
    private int rear;
    //front的默认值是0
    private int front;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //向队列添加数据
    public void push(int num){
        if (isFull()){
            System.out.println("队列已满,请清除再试");
            return;
        }
        arr[rear]=num;
        rear = (rear+1)%maxSize;
    }
    //从队列中取出数据
    public int pull(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,无法取出数据");
        }
        int i = arr[front];
        front = (front+1)%maxSize;
        return i;
    }

    //队列的有效个数
    private int size(){
       return (rear+maxSize-front)%maxSize;
    }

    //展示队列
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,没有数据");
        }
        for (int i=front;i<front+size();i++){
            System.out.println(arr[i]+" ");
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,没有数据");
        }
        return arr[front];
    }
}
