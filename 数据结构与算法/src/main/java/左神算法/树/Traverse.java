package 左神算法.树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traverse {

    static class Node {
        int val;
        Node left;
        Node right;
    }

    public static void preOrder(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            System.out.println(root.val);
            root = root.right;
        }
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Node> res = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.removeLast();
            res.addFirst(root);
            if (root.left != null) {
                stack.add(root.left);
            }
            if (root.right != null) {
                stack.add(root.right);
            }
        }
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.println(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }
}
