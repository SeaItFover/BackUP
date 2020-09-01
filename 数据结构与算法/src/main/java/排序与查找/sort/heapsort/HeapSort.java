package 排序与查找.sort.heapsort;

import java.util.Arrays;

/**
 * 升序排序用大顶堆
 * 降序排序用小顶堆
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] tree = new int[]{1, 4, 7, 3, 10};
        //int length = tree.length;
        heapSort(tree);
        System.out.println(Arrays.toString(tree));
    }

    public static void heapSort(int[] tree) {
        for (int i = (tree.length - 1) / 2; i >= 0; i--) {
            heapify(tree, i, tree.length);
        }
    }

    private static void swap(int[] tree, int i, int j) {
        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }

    public static void heapify(int[] tree, int root, int length) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int max = root;
        while (left < length) {
            if (tree[max] < tree[left]) {
                max = left;
            }
            if (right < length && tree[max] < tree[right]) {
                max = right;
            }
            if (max != root) {
                swap(tree, root, max);

            }else {
                break;
            }
            root = max;
            left = 2 * root + 1;
            right = 2 * root + 2;
        }
        /*if (left < length && max < tree[left]) {
            max = tree[left];
        }
        if (right < length && max < tree[right]) {
            max = tree[right];
        }
        if (max != tree[root]) {
            if (left < length && max == tree[left]) {
                tree[left] = tree[root];
                heapify(tree, left, length);
            }
            if (right < length && max == tree[right]) {
                tree[right] = tree[root];
                heapify(tree, right, length);
            }
            tree[root] = max;
        }*/
    }
}
