package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String expression = "1+((20+4)/4)-(15-5)";//注意表达式
        List<String> infixString = toInfixString(expression);//中缀表达式
        System.out.println(infixString);
        List<String> suffixString = toSuffixString(infixString);//后缀表达式
        System.out.println(suffixString);
        //ArrayList[1,2,3,+,4,*,+,5,–]
        System.out.println("===========================");
        System.out.println("计算结果为"+calculate(suffixString));;
    }

    /**
     * 弹栈运算
     * @param suffixString
     * @return
     */
    public static int calculate(List<String> suffixString){
        int res = 0;
        Stack<String> stack = new Stack<>();
        for (String s : suffixString) {
            if (isNum(s)){
                stack.push(s);
            }else {
                String s1 = stack.pop();
                String s2 = stack.pop();
                res = cal(Integer.parseInt(s1),Integer.parseInt(s2),s);
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private static List<String> toSuffixString(List<String> infixString) {
        Stack<String> operStack = new Stack<>();
        List<String> numStack = new ArrayList<>();
        for (String s : infixString) {
            if (isOper(s)) {
                while (operStack.size() > 0 && priority(s) <= priority(operStack.peek())) {
                    numStack.add(operStack.pop());
                }
                operStack.push(s);
            } else {
                if (s.equals(")")) {
                    while (!operStack.peek().equals("(")) {
                        numStack.add(operStack.pop());
                    }
                    operStack.pop();
                } else if (s.equals("(")) {
                    operStack.push(s);
                } else {
                    numStack.add(s);
                }
            }
        }
        while (!operStack.isEmpty()){
            numStack.add(operStack.pop());
        }
        return numStack;
    }

    /**
     * @param exp
     * @return
     */
    public static List<String> toInfixString(String exp) {
        char ch = ' ';
        String str = "";
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < exp.length()){
            ch = exp.charAt(i);
            str += ch;
            //判断字符串下标的字符是数字还是运算符
            if (isNum(str)) {
                //如果是数字,循环判断是不是最后一个索引和下一个字符是不是数字
                while (i != exp.length() - 1 && isNum(exp.charAt(++i) + "")) {
                    //如果下个字符是数字,拼接字符串
                    ch = exp.charAt(i);
                    str += ch;
                }
                //不是就将str添加到list中,清空str
                list.add(str);
                str = "";
                if (i==exp.length()-1&&isNum(exp.charAt(i)+"")){
                    break;
                }
            } else {
                list.add(str);
                str = "";
                i++;
            }
        }
        return list;
    }

    private static boolean isNum(String oper) {
        return !isOper(oper) && !oper.equals("(") && !oper.equals(")");
    }

    /**
     * 判断扫描的字符是否是符号
     *
     * @param oper
     * @return
     */
    public static boolean isOper(String oper) {
        return "*".equals(oper) || "/".equals(oper) || "+".equals(oper) || "-".equals(oper);
    }

    //计算
    public static int cal(int num1, int num2, String oper) {
        int res = 0;
        if ("*".equals(oper)) {
            res = num1 * num2;
        } else if ("/".equals(oper)) {
            res = num2 / num1;
        } else if ("+".equals(oper)) {
            res = num1 + num2;
        } else if ("-".equals(oper)) {
            res = num2 - num1;
        }
        return res;
    }

    //定义运算符的级别
    public static int priority(String oper) {
        if (oper.equals("*") || oper.equals("/")) {
            return 2;
        }
        if (oper.equals("+") || oper.equals("-")) {
            return 1;
        }
        return 0;
    }
}


