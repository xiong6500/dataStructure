package com.atguigu.linkedList;

import java.util.Stack;

/**
 * 模拟单项列表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        //显示
        singleLinkedList.list();
        System.out.println("-----------------");
        //删除一个节点
        singleLinkedList.delNode(5);
        singleLinkedList.list();
        System.out.println("------------------------");
        //修改节点
        singleLinkedList.update(new HeroNode(2,"秦明","霹雳火"));
        singleLinkedList.list();
        //有效节点的个数
        System.out.println("================================");
        System.out.println("该链表的有效节点个数为"+singleLinkedList.getNodeNum());
        //倒数第3个节点
        System.out.println("倒数第三个节点为"+singleLinkedList.backNode(3));
        System.out.println("================================");
        singleLinkedList.reverse();
        System.out.println("反转后的链表为:");
        singleLinkedList.list();
        System.out.println("================================");
        System.out.println("反向打印列表");
        singleLinkedList.backPrint();
    }



}

class SingleLinkedList {

    private HeroNode headNode = new HeroNode(0, "", "");

    /**
     * 利用栈的方式从尾到头打印单链表
     */
    public void backPrint(){
        HeroNode temp = headNode.next;
        Stack stack = new Stack();
        while (temp!=null){
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()){
            HeroNode pop = (HeroNode) stack.pop();
            System.out.println(pop);
        }
    }

    /**
     * 单链表的反转【腾讯面试题，有点难度】
     */

    public void reverse(){
        HeroNode temp = headNode.next;
        HeroNode newHeadNode = new HeroNode(0,"","");
        while (temp!=null){
            HeroNode var = temp.next;
            temp.next = newHeadNode.next;
            newHeadNode.next = temp;
            temp = var;
        }
        this.headNode = newHeadNode;
    }

    /**
     * 求单链表中有效节点的个数
     */
    public int getNodeNum(){
        int count = 0;
        HeroNode temp = headNode.next;
        while (temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    //查找单链表中的倒数第k个结点【新浪面试题】
    public HeroNode backNode(int k){
        HeroNode temp = headNode;
        int count = getNodeNum();
        for (int i=0;i<count-k+1;i++){
            temp = temp.next;
        }
        return temp;
    }

    //遍历整个链表
    public void list() {
        if (headNode.next == null) {
            System.out.println("链表为空,无法遍历");
            return;
        }
        HeroNode node = headNode.next;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

    //根据no的顺序对链表添加数据
    public void addByOrder(HeroNode node){
        HeroNode temp = headNode;
        while (temp.next!=null){
            if (temp.next.no > node.no){
                HeroNode var = temp.next;
                temp.next = node;
                node.next = var;
                return;
            }
            temp = temp.next;
        }
        temp.next = node;
    }
    //在链表中添加数据
    public void add(HeroNode node) {
        HeroNode temp = headNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    //修改节点信息,根据no编号来修改,即no不能修改
    public void update(HeroNode newHeroNode) {
        HeroNode temp = headNode;
        while (temp.next != null) {
            if (temp.next.no == newHeroNode.no) {
                HeroNode var = temp.next.next;
                temp.next = newHeroNode;
                newHeroNode.next = var;
                return;
            }
            temp = temp.next;
        }
        System.out.println("该链表找不到"+newHeroNode.no+"的数据");
    }

    //根据no删除节点
    public void delNode(int no){
        HeroNode temp = headNode;
        while (temp.next!=null){
            if (temp.next.no==no){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.printf("要删除的%d节点不存在\n",no);
    }
}

class HeroNode {
    int no;
    String name;
    String nickName;
    HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
