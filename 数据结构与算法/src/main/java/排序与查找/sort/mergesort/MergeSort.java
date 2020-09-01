package 排序与查找.sort.mergesort;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class MergeSort {
    public static void main(String[] args) {
        char c = '\u0000';
        System.out.println("sss"+c+"str");
        /*int[] arr = new int[]{7, 4, 5, 1, 9, 4, 8, 3};
        //merge(arr, 0, 3, arr.length - 1);
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));*/
    }
    //算法核心有两个：
    //一是通过递归拆分数组
    //二是对两个数组（其实是一个数组）进行比较排序放入新的临时数组
    //将这两个核心抽象成两个方法

    //对数组进行拆分（通过递归的方式）
    public static void  mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (high + low)/2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle+1, high);
            merge(arr,low,middle,high);
        }
    }

    //排序一个给定的数组
    private static void merge(int[] arr, int low, int middle, int high) {
        //首先需要需要一个临时数组用于存放比较后的数据，它的长度
        int[] temp = new int[high - low + 1];
        //需要一个指标指向左边数组并进行移动
        int i = low;
        //需要一个指标指向右边数组并进行移动
        int j = middle + 1;
        //需要一个指标记录临时数组的下标
        int index = 0;
        //开始比较左右两个数组指标所指向的值大小
        //这里和快排不一样的是，每一次指标比较时，不管结果如何都要进行相应的操作
        //（要么左边的值放入临时数组，要么右边的值放入临时数组）
        //快排则不然，如果右边的值一直大于标准值，那么指标一直往前移动
        //所以这里用的是if判断语句，而非while循环
        while (i <= middle && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }//循环结束代表左边或者右边已经没有元素可以比较
        //处理剩余元素
        //System.out.println(i);

        /*if (i < middle) {
            for (int k = i; k < middle; k++) {
                temp[index] = arr[k];
                index++;
            }
        } else {
            for (int k = j; k < high; k++) {
                temp[index] = arr[k];
                index++;
            }
        }*/
        //什么时候用for，什么时候用while（明确循环次数时一般用for，否则用while比较简单明了）
        while (j<=high){
            temp[index] = arr[j];
            j++;
            index++;
        }
        while (i<=middle){
            temp[index] = arr[i];
            i++;
            index++;
        }
        //处理完剩余数据 之后，将temp数组赋值给arr数组
        for (int m = 0; m < temp.length ; m++) {
            //arr[m] = temp[m];
            arr[low+m] = temp[m]; //重要，重新赋值给原数组时，注意arr数组的下标位置
        }
        //System.out.println(Arrays.toString(arr));

    }
}
