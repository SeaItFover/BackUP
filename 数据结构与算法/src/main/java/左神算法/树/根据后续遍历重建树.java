package 左神算法.树;

/**
 * 最坏时间复杂度是  O(n^2)
 * 可以优化：使用二分查找
 */
public class 根据后续遍历重建树 {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node postArr(int[] arr) {
        return pos(arr, 0, arr.length - 1);
    }

    private static Node pos(int[] arr, int L, int R) {
        if (L > R) {
            return null;
        }
        Node head = new Node(arr[R]);
        if (L == R) {
            return head;
        }
        int M = L - 1;
        for (int i = L; i < R; i++) {
            if (arr[i] < head.value) {
                M = i;
            } else {
                break;
            }
        }
        head.left = pos(arr, 0, M);
        head.right = pos(arr, M + 1, R - 1);//这里是R-1
        return head;
    }

    private static Node pos2(int[] arr, int L, int R) {
        if (L > R) {
            return null;
        }
        Node head = new Node(arr[R]);
        if (L == R) {
            return head;
        }
        int M = L - 1;
        //使用二分查找那个M
        int left = L;
        int right = R - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (arr[mid] < head.value) {
                M = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        head.left = pos2(arr, L, M);
        head.right = pos2(arr, M + 1, R - 1);
        return head;
    }

    public static void main(String[] args) {

    }
}
