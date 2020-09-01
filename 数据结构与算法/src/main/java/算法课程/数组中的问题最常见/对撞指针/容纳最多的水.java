package 算法课程.数组中的问题最常见.对撞指针;

/**
 * 11给定一个非负整数，每一个整数表示一个竖立在x周上的墙，选择两堵墙，和x轴可以容纳最多的水
 */
public class 容纳最多的水 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }

    //暴力解法：时间复杂度：O(n^2)
    public static int maxArea(int[] arr){
        int ret = 0;
        for (int i = 0; i < arr.length-1;i++){
            for (int j = i+1; j<arr.length; j++){
                ret = Math.max(ret,(j-i)*(Math.min(arr[i],arr[j])));
            }
        }
        return ret;
    }

}
