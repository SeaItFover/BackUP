package leetcode.数据结构.树;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstructTree {

    static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Queue<String> preSerial(Node head) {
        Queue<String> res = new LinkedList<>();
        pres(head, res);
        return res;
    }

    private static void pres(Node head, Queue<String> res) {
        if (head == null) {
            res.add(null);
        } else {
            res.add(String.valueOf(head.value));
            pres(head.left, res);
            pres(head.right, res);
        }
    }

    public static Node buildByPreQueue(Queue<String> preList) {
        if (preList == null || preList.size() == 0) {
            return null;
        }
        return preb(preList);
    }

    private static Node preb(Queue<String> preList) {
        String value = preList.poll();
        if (value == null) {
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = preb(preList);
        head.right = preb(preList);
        return head;
    }

    public static Queue<String> levelSerial(Node head) {
        Queue<String> res = new LinkedList<>();
        if (head == null) {
            res.add(null);
        } else {
            res.add(String.valueOf(head.value));
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                if (head.left != null) {
                    res.add(String.valueOf(head.left.value));
                    queue.add(head.left);
                } else {
                    res.add(null);
                }
                if (head.right != null) {
                    res.add(String.valueOf(head.right.value));
                    queue.add(head.right);
                } else {
                    res.add(null);
                }
            }
        }
        return res;
    }

    public static Node buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.size() == 0) {
            return null;
        }
        Node head =generateNode(levelList.poll());
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNode(levelList.poll());
            node.right = generateNode(levelList.poll());
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }

    public static Node generateNode(String value) {
        if (value == null) {
            return null;
        }
        return new Node(Integer.valueOf(value));
    }
}
