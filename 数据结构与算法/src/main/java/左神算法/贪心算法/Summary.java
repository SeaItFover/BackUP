package 左神算法.贪心算法;

import java.util.*;

public class Summary {

    public static void main(String[] args) {



        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(8);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        treeNode3.left = treeNode7;
        //preOrder(treeNode);
        //inOrder(treeNode);
        //postOrder(treeNode);
        transByLevel(treeNode);


        /*int[] arr = new int[]{2, 3, 1234, 345, 31, 4, 76, 34, 3542, 453, 5436, 564, 653, 23, 7, 5432, 78666, 675, 4, 1};
        System.out.println(Arrays.toString(getMinN(arr, 0)));*/

//        System.out.println(getMinCost(new int[]{10, 20, 30}));

        /*QueueByArray queue = new QueueByArray(3);
        queue.push(1);
        queue.push(2);
        queue.push(2);
        System.out.println(queue.poll());
        queue.poll();
        queue.poll();
        System.out.println(queue.size);*/

        /*String str = "111222111";
        /*String str = "111222111";
        System.out.println(manacher(str));
        String aim = "d";
        System.out.println(getIndexOf(str, aim));*/
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> res = new LinkedList<>();
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
        for (TreeNode tn : res) {
            System.out.println(tn.val);
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
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

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.removeLast();
            System.out.println(root.val);
            if (root.right != null) {
                stack.add(root.right);
            }
            if (root.left != null) {
                stack.add(root.left);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void transByLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.println(root.val);;
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }

    public static class Node {
        int p;
        int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Node> minCost = new PriorityQueue<>(Comparator.comparingInt(n -> n.c));
        PriorityQueue<Node> maxPro = new PriorityQueue<Node>((n1, n2) -> n2.p - n1.p);

        for (int i = 0; i < Profits.length; i++) {
            minCost.add(new Node(Profits[i], Capital[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && W >= minCost.peek().c) {
                maxPro.add(minCost.poll());
            }
            if (maxPro.isEmpty()) {
                return W;
            }
            W += maxPro.poll().p;
        }
        return W;
    }

    public static int[] getMinN(int[] arr, int k) {
        if (arr == null || arr.length < k || k < 1) {
            return arr;
        }
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            insertHeap(heap, arr[i], i);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < heap[0]) {
                heap[0] = arr[i];
                heapify(heap, 0, k);
            }
        }
        return heap;
    }

    public static void heapify(int[] heap, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        while (left < length) {
            if (heap[left] > heap[max]) {
                max = left;
            }
            if (right < length && heap[right] > heap[max]) {
                max = right;
            }
            if (max != i) {
                swap(heap, max, i);
            } else {
                break;
            }
            i = max;
            left = 2 * i + 1;
            right = 2 * i + 2;
        }
    }

    public static void insertHeap(int[] heap, int value, int i) {
        heap[i] = value;
        while (i != 0) {
            int parent = (i - 1) >> 1;
            if (heap[parent] < heap[i]) {
                swap(heap, parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int getMinCost(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int a : arr) {
            queue.add(a);
        }
        int res = 0;
        while (queue.size() > 1) {
            int min = queue.poll() + queue.poll();
            queue.add(min);
            res += min;
        }
        return res;
    }

    public static class SpecialStack<Integer> {
        Stack<Integer> data;
        Stack<Integer> min;

        public SpecialStack() {
            this.data = new Stack<>();
            this.min = new Stack<>();
        }

        public void push(Integer integer) {
            if (min.isEmpty()) {
                min.push(integer);
            } else if (integer != min.peek()) {
                min.push(min.peek());
            } else {
                min.push(integer);
            }
            data.push(integer);
        }

        public Integer pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            min.pop();
            return data.pop();
        }

        public Integer getMin() {
            if (min.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return min.peek();
        }
    }

    public static class QueueByStack<K> {
        Stack<K> in;
        Stack<K> out;

        public QueueByStack() {
            this.in = new Stack<>();
            this.out = new Stack<>();
        }

        public void push(K k) {
            in.push(k);
        }

        public K peek() {
            if (in.isEmpty() && out.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public K poll() {
            if (in.isEmpty() && out.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }
    }

    //Array -> Queue
    public static class QueueByArray {
        int[] queue;
        int start;
        int end;
        int size;

        public QueueByArray(int initCap) {
            this.queue = new int[initCap];
            this.start = 0;
            this.end = 0;
            this.size = 0;
        }

        public int peek() {
            if (size == 0) {
                throw new RuntimeException("queue is empty");
            }
            return queue[start];
        }

        public void push(int num) {
            if (size == queue.length) {
                throw new RuntimeException("queue is full");
            }
            size++;
            queue[end] = num;
            end = end == queue.length - 1 ? 0 : end + 1;
        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("queue is empty");
            }
            size--;
            int temp = start;
            start = start == queue.length - 1 ? 0 : start + 1;
            return queue[temp];
        }
    }

    public static int manacher(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        String s = getStr(str);
        int C = -1;
        int R = -1;
        int i = 0;
        int[] pArr = new int[s.length()];
        int max = 0;
        while (i < s.length()) {
            pArr[i] = R > i ? Math.min(R - i, pArr[2 * C - i]) : 1;
            while (i + pArr[i] < s.length() && i - pArr[i] >= 0) {
                if (s.charAt(i + pArr[i]) == s.charAt(i - pArr[i])) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
            i++;
        }
        return max - 1;
    }

    public static String getStr(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }

    public static int getIndexOf(String str, String aim) {
        if (str == null || aim == null || str.length() < aim.length() || aim.length() < 1) {
            return -1;
        }
        int i1 = 0;
        int i2 = 0;
        int[] next = getNext(aim);
        while (i1 < str.length() && i2 < aim.length()) {
            if (str.charAt(i1) == aim.charAt(i2)) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == aim.length() ? i1 - i2 : -1;
    }

    public static int[] getNext(String str) {
        if (str.length() == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length()];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while (i < str.length()) {
            if (str.charAt(i - 1) == str.charAt(cn)) {
                next[i++] = ++cn;
            } else if (cn == -1) {
                next[i++] = 0;
            } else {
                cn = next[cn];
            }
        }
        return next;
    }
}
