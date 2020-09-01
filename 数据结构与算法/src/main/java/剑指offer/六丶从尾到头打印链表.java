package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

public class 六丶从尾到头打印链表 {
    public static void main(String[] args) {
        //单链表的创建
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(9);
        node1.append(node2).append(node3).append(node4).append(node5);
        System.out.println(printListFromTailToHead(node1));
        System.out.println(printListFromTailToHead02(node1));
    }

    public static ArrayList<Integer> printListFromTailToHead (ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.add(listNode.data);
            listNode = listNode.next;
        }
        ArrayList<Integer> req = new ArrayList<>();
        while (!stack.empty()){
            req.add(stack.pop());
        }
        return req;
    }

    public static ArrayList<Integer> printListFromTailToHead02(ListNode listNode){
        //采用递归的方式
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode != null){  //这里不能用while，否则会陷入死循环，必须用if判断一次
            arrayList.addAll(printListFromTailToHead02(listNode.next));
            arrayList.add(listNode.data);
        }
        return arrayList;
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data){
        this.data = data;
    }

    //为节点追加节点
    public ListNode append(ListNode node){
        //当前节点
        ListNode currentNode = this;
        //循环向后找
        while (true){
            //取出下一个节点
            ListNode nextNode = currentNode.next;
            //如果下一个节点为null，说明当前节点已经是最后一个节点
            if(nextNode == null){
                break;
            }
            //如果下一个节点不为null，将下一个节点赋给当前节点
            currentNode = nextNode;
        }
        //将新节点赋给当前节点（始终指向最后一个节点）的下一个节点
        currentNode.next = node;
        return node;
    }

    public ListNode next(){
        return this.next;
    }

    public int getData(){

        return this.data;
    }

    public boolean isLast(){
        return next == null;
    }

    public void removeNext(){
        next = next.next;
    }

    public void show(){
        ListNode currentNode = this;
        while (true){
            System.out.print(currentNode.data+" ");
            currentNode = currentNode.next;
            if (currentNode == null){
                break;
            }
        }
        System.out.println();
    }

    public void insertNode(ListNode node){
        ListNode nextNext = next;
        next = node;
        node.next = nextNext;
    }
}