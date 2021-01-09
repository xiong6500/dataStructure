package com.atguigu.queue;

import java.util.Scanner;

public class CircleQueueTest2 {
    public static void main(String[] args) {
        CircleQueue2 circleQueue = new CircleQueue2(4);
        char key = ' ';//接收用户收入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接受一个字符
            switch (key) {
                case 's':
                    circleQueue.list();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    circleQueue.add(value);
                    break;
                case 'g':
                    try {
                        int res = circleQueue.remove();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleQueue.peek();
                        System.out.printf("头数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("已经退出");
                    loop = false;
                    break;
            }
        }
    }
}

class CircleQueue2 {
    public int[] arr;
    public int maxsize;
    public int rear;
    public int front;

    public CircleQueue2(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
    }

    //是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //数组是否满了
    public boolean isFull() {
        return (rear + 1) % maxsize == front;
    }

    //添加数据
    public void add(int num) {
        if (isFull()) {
            System.out.println("队列满了,不能添加数据了");
        } else {
            arr[rear] = num;
            rear = (rear + 1) % maxsize;
        }

    }

    //移除数据
    public int remove() {
        if (isEmpty()){
            throw new RuntimeException("队列为空,不能从里面拿出数据");
        }
        int num = arr[front];
        front = (front + 1) % maxsize;
        return num;
    }

    //展现队列的头数据
    public int peek() {
        return arr[front];
    }

    //展现队列数据
    public void list() {
        if (isEmpty()){
            throw new RuntimeException("队列为空,没有数据");
        }
        int count = front;
        for (int i = 0; i < size(); i++) {
            System.out.println(arr[count]);
            count = (count+1)%maxsize;
        }
    }

    //队列的大小
    public int size() {
        return (rear - front + maxsize) % maxsize;
    }
}