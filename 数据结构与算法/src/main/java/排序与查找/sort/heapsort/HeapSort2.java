package 排序与查找.sort.heapsort;

import java.util.Arrays;

public class HeapSort2 {

    public static void main(String[] args) {
        int[] tree = new int[]{5,2,1,7,9,0,3,8};
        int length = tree.length;
        heapSort(tree,length);
        System.out.println(Arrays.toString(tree));
    }

    public static void heapSort(int[] tree,int length){
        for (int i = (length-1)/2;i>=0;i--){
            heapify(tree,length,i);
        }
    }

    private static void heapify(int[] tree,int length,int root){
        int left = 2*root + 1;
        int right = 2*root + 2;
        int max = tree[root];
        if (left < length && max < tree[left]){
            max = tree[left];
        }
        if (right < length && max < tree[right]){
            max = tree[right];
        }
        if (max != tree[root]){
            if (left < length && max == tree[left]){
                tree[left] = tree[root];
                heapify(tree,length,left);
            }
            if (right <length && max == tree[right]){
                tree[right] = tree[root];
                heapify(tree,length,right);
            }
            tree[root] = max;
        }
    }
}
