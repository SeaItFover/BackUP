package 左神算法.树;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {

    static class Node {
        private int value;
        private Node left;
        private Node right;
    }

    public static int treeMaxWidth2(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head;
        Node nextEnd = null;
        int max = 0;
        int curLevelNodes = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if (cur == curEnd) {
                max = Math.max(max, curLevelNodes);
                curEnd = nextEnd;
                curLevelNodes = 0;
            }
        }
        return max;
    }

    public static int treeMaxWidth(Node head) {
        HashMap<Node, Integer> levelMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int curNodeLevel = levelMap.get(curNode);
            if (curNode.left != null) {
                queue.add(curNode.left);
                levelMap.put(curNode.left, curNodeLevel + 1);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
                levelMap.put(curNode.right, curNodeLevel + 1);
            }
            if (curLevel == curNodeLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }
}
