package com.atguigu.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "12+5*6-3+1";//15//如何处理多位数的问题
        StackayStack2 numStack = new StackayStack2(10);//数栈
        StackayStack2 operStack = new StackayStack2(10);//符号栈
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char c = ' ';
        String keepNum = "";//用于拼接多位数
        for (int i = 0; i < expression.length(); i++) {
            c = expression.charAt(i);
            if (operStack.isOper(c)) {
                if (operStack.isEmpty()) {
                    operStack.push(c);
                } else {
                    if (operStack.priority(c) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = operStack.cal(num1, num2, oper);
                        numStack.push(res);
                    }
                    operStack.push(c);
                }
            } else {
                keepNum += c;
                if (i == expression.length() - 1) {
                   numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (operStack.isOper(expression.substring(i+1,i+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
        }
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = operStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("运算结果为" + res);
    }

}

class StackayStack2 {
    private int maxsize;
    private int[] stack;
    private int top = -1;

    public StackayStack2(int maxsize) {
        this.maxsize = maxsize;
        stack = new int[this.maxsize];
    }

    public boolean isFull() {
        return maxsize == top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //进栈
    public void push(int num) {
        if (isFull()) {
            System.out.println("栈已经满了,请清除栈中数据");
            return;
        }
        top++;
        stack[top] = num;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈内为空,没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈顶
    public int peek() {
        return stack[top];
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈内为空,没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            default:
                break;
        }
        return res;
    }
}