package com.atguigu.linkedList;

/**
 * Josephu问题为：设编号为1，2，...n的n个人围坐一圈，
 * 约定编号为k（1<=k<=n）的人从1开始报数，数到m的那个人出列，
 * 它的下一位又从1开始报数，数到m的那个人又出列，依次类推，
 * 直到所有人出列为止，由此产生一个出队编号的序列。
 *
 * 假设5个人 数到2的那个人出列,顺序是
 */
public class JosephuDemo {

    public static void main(String[] args) {
        SingleCircleList singleCircleList= new SingleCircleList();
        singleCircleList.add(5);
//        singleCircleList.list();
        System.out.println("========================");
        singleCircleList.countNode(1,2,5);
//        singleCircleList.list();
    }
}

class SingleCircleList{
    private Node headNode=null;

    /**
     * 在链表中添加节点
     */
    public void add(int num){
        if (num<1){
            System.out.println("添加错误,请输入正确的数字");
            return;
        }
        headNode = new Node(1);
        Node temp = headNode;
        for (int i=1;i<num;i++){
            Node node = new Node(i+1);
            temp.next = node;
            temp = node;
            if (i==num-1){
                node.next = headNode;
            }
        }
    }

    //展示所有的节点
    public void list(){
        if (headNode==null){
            System.out.println("该链表为空,无法遍历");
            return;
        }
        Node temp = headNode;
        while (temp.next!=headNode){
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println(temp);
    }

    //根据用户的输入，计算出小孩出圈的顺序
    public void countNode(int startNo,int countNum,int num){
        Node first = headNode;
        Node helper  = headNode;
        while (helper.next!=headNode){
            helper = helper.next;
        }
        for (int i=0;i<startNo-1;i++){
            first = first.next;
            helper = helper.next;
        }
        while (num!=0){
            for (int j=0;j<countNum-1;j++){
                first = first.next;
                helper = helper.next;
            }
            System.out.println(first);
            first = first.next;
            helper.next = first;
            num--;
        }

    }
}

class Node{
    int no;
    Node next;

    public Node() {
    }

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
