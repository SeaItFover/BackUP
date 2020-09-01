package 左神算法.树;

public class RecursiveTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node (int value) {
            this.value = value;
        }
    }

    public static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void inOrder(Node head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.println(head.value);
        inOrder(head.right);
    }

    public static void postOrder(Node head) {
        if (head == null) {
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.println(head.value);
    }
}
