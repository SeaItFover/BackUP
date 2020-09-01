package 左神算法.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 平衡二叉树：对于任何一颗子树，左右子树的高度差不大于1
 * 搜索二叉树：根节点大于它左子树上所有节点，小于右子树上所有节点（利用中序遍历）
 *
 */
public class 一棵树是否是某种特殊的树 {

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int data) {
            this.val = data;
        }
    }

    public static class ReturnData {
        public boolean isB;
        public int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    public static boolean isB(Node head) {
        return process(head).isB;
    }

    public static ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftData = process(head.left);
        if (!leftData.isB) {
            return new ReturnData(false, 0);
        }
        ReturnData rightData = process(head.right);
        if (!rightData.isB) {
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
    }

    //递归
    public static boolean isBalance(Node root) {
        return process(root).isB;
    }

    //判断是否是完全二叉树
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null) || (l == null) && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}
