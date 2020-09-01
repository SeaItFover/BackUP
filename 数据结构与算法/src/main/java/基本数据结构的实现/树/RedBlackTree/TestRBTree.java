package 基本数据结构的实现.树.RedBlackTree;

import java.util.Scanner;

public class TestRBTree {
    public static void main(String[] args) {
        RBTree<String, Object> rbt = new RBTree();
        //测试输入：ijkgefhdabc
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入key:");
            String key = sc.next();

            rbt.insert(key, null);
            TreeOperation.show(rbt.getRoot());
        }
    }
}
