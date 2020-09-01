package leetcode.数据结构.链表.自定义链表;

public class Test01 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("刘备");
        linkedList.add("关羽");
        linkedList.add("张飞");
        linkedList.add(1,"AA");
        for (int i = 0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
        }
        System.out.println(linkedList.size());

    }
}
