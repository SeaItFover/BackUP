package 排序与查找.sort.heapsort;

import java.util.Arrays;

public class HeapSort3 {

    public static void main(String[] args) {
        int[] arr= new int[]{5,2,1,7,0,9,5,6,3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] tree){
        for (int i = (tree.length-1)/2; i>=0;i--){
            heapify(tree,i);
        }
    }

    private static void heapify(int[] tree,int root){
        int left = 2*root + 1;
        int right = 2*root + 2;
        int max = tree[root];
        if (left < tree.length && max < tree[left]){
            max = tree[left];
        }
        if (right < tree.length && max <tree[right]){
            max = tree[right];
        }
        if (left < tree.length && max == tree[left]){
            tree[left] = tree[root];
            heapify(tree,left);
        }
        if (right < tree.length && max == tree[right]){
            tree[right] = tree[root];
            heapify(tree,right);
        }
        tree[root] = max;
    }
}
