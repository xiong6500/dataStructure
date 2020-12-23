package com.atguigu.linkedList;

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
        //
    }
}

class SingleLinkedList {

    private HeroNode headNode = new HeroNode(0, "", "");

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
