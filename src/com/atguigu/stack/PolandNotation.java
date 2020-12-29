package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String expression="1+((2+3)*4)-5";//注意表达式
        List<String> infixString = toInfixString(expression);//中缀表达式
        List<String> suffixString = toSuffixString(infixString);//后缀表达式
        System.out.println(suffixString);
        //ArrayList[1,2,3,+,4,*,+,5,–]
        
    }

    private static List<String> toSuffixString(List<String> infixString) {
        Stack<String> operStack = new Stack<>();
        List<String> numStack = new ArrayList<>();
        for (String s : infixString) {
            if (isOper(s)){
                while (operStack.size()>0 && priority(s)<=priority(operStack.peek())){
                    numStack.add(operStack.pop());
                }
                operStack.push(s);
            }else {
                if (s.equals(")")){
                    while (!operStack.peek().equals("(")){
                        numStack.add(operStack.pop());
                    }
                    operStack.pop();
                }else if (s.equals("(")){
                    operStack.push(s);
                } else {
                    numStack.add(s);
                }
            }
        }
        return numStack;
    }

    public static List<String> toInfixString(String exp){
        char ch = ' ';
        List<String> list = new ArrayList<>();
        for (int i=0;i<exp.length();i++){
            ch = exp.charAt(i);
            list.add(""+ch);
        }
        return list;
    }

    /**
     * 判断扫描的字符是否是符号
     * @param oper
     * @return
     */
    public static boolean isOper(String oper){
        return "*".equals(oper) || "/".equals(oper) || "+".equals(oper) || "-".equals(oper);
    }

    //计算
    public static int cal(int num1,int num2,String oper){
        int res = 0;
        if ("*".equals(oper)){
            res = num1 * num2;
        }else if ("/".equals(oper)){
            res = num2 / num1;
        }else if ("+".equals(oper)){
            res = num1 + num2;
        }else if ("-".equals(oper)){
            res = num2 - num1;
        }
        return res;
    }

    //定义运算符的级别
    public static int priority(String oper){
        if (oper.equals("*")  || oper.equals("/")){
            return 2;
        }
        if (oper.equals("+") || oper.equals("-")){
            return 1;
        }
        return 0;
    }
}


