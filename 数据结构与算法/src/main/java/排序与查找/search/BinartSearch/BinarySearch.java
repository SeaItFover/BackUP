package 排序与查找.search.BinartSearch;

/**
 * 二分查找法前提一定是数组元素有序。
 * 时间复杂度：O(logn)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 9, 10};
        int index;
        if ((index = binarySearch(arr, 4)) != -1) {
            System.out.println(index);
        } else {
            System.out.println("没有目标值");
        }
        if ((index = binarySearch2(arr, 6)) != -1) {
            System.out.println(index);
        } else {
            System.out.println("没有目标值");
        }
    }

    public static int binarySearch(int[] arr, int target) {
        //l,r分别表示左右区间，这是一个闭区间
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] arr, int target) {
        //l,r分别是左右区间，左闭右开
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if(arr[mid] > target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
