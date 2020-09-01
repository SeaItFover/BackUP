package 左神算法.树;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstructTree{

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static String serialByPre(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node reConByPreString(String preStr) {
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reConPreOrder(queue);
    }

    public static Node reConPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reConPreOrder(queue);
        head.right = reConPreOrder(queue);
        return head;
    }

    public static String serialByLevel(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.val + "!";
                queue.add(head.left);
            } else {
                res += "#!";
            }
            if (head.right != null) {
                res += head.right.val + "!";
                queue.add(head.right);
            }else {
                res += "#!";
            }
        }
        return res;
    }

    public static Node reconByLevelString(String levelStr) {
        String[] values = levelStr.split("!");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }

    public static Node generateNodeByString(String val){
        if (val.equals("#")) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }
}
