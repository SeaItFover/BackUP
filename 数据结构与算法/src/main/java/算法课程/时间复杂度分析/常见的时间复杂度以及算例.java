package 算法课程.时间复杂度分析;

import java.util.Arrays;

public class 常见的时间复杂度以及算例 {
    public static void main(String[] args) {
        String str = ("woaini");
        System.out.println(reverseString(str));
        int[] arr = {1, 4, 2, 7, 5, 9, 2, 8, 1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        //insertSort(arr);
        //selectSort(arr);
        //System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 3));
        System.out.println();
    }

    //O(n)翻转字符串
    public static String reverseString(String str) {
        char[] c = str.toCharArray();
        System.out.println(Arrays.toString(c));
        System.out.println(str.length() == c.length);
        for (int i = 0; i <= ((str.length() - 1) / 2); i++) {
            char temp = c[i];
            c[i] = c[c.length - 1 - i];
            c[c.length - 1 - i] = temp;
        }
        return new String(c);
    }

    //O(1)交换两个int类型整数
    public static void swapTwoInts(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        /**
         * a = a ^ b;
         * b = a ^ b;
         * a = a ^ b;
         */
    }

    //O(n^2)选择排序
    public static void selectSort(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // O(n^2)  插入排序
    public static void insertSort(int[] arr){
        for (int i = 1; i <arr.length; i++){
            for (int j = i-1; j>=0; j--){
                if (arr[j+1] < arr[j]){ //这里比较的不是i和j的大小，因为i是定值，而我们要比较的是相邻元素的值
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }else {
                    break;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] arr,int start, int end){
        if (start < end){
            int standard = arr[start];
            int low = start;
            int high = end;
            //System.out.println(arr[high]);

            //这里不能加等号，因为如果指标相等了，就不需要进行比较排序了
            while (low < high){
                while (low < high && arr[high] >= standard){ //
                    high--;
                }
                //System.out.println(high+","+low);
                arr[low] = arr[high];
                while (low < high && arr[low] <= standard){
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = standard;
            quickSort(arr,start,low);
            quickSort(arr,low+1,end);
        }
    }

    //归并排序
    public static void mergeSort(int[] arr){

    }

    //O(logn) 二分查找
    public static boolean binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (target == arr[mid]) {
                return true;
            } else if (target > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    //O(sqrt(n))
    public static boolean isPrime(int n) {
        if (n == 1 || n == 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //递归中进行一次调用的复杂度分析
    public static double pow(double x, int n){
        if (n < 0){
            throw new IllegalArgumentException("n" + ","+n);
        }
        if (n == 0){
            return 1.0;
        }
        double t = pow(x,n/2);
        if (n/2 != 0){
            return t * t * x;
        }
        return t*t;
    }

    //递归中进行多次调用的复杂度分析
    public static int fibonaqi(int n){
        if (n<0){
            throw new IllegalArgumentException("n" + n);
        }
        if (n == 0){
            return 1;
        }
        return fibonaqi(n-1)+fibonaqi(n-1);
    }
}