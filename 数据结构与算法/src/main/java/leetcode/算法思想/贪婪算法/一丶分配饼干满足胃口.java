package leetcode.算法思想.贪婪算法;

import java.util.Arrays;

public class 一丶分配饼干满足胃口 {

    public static void main(String[] args) {
        int[] grid = {1,3};
        int[] size = {1,2,4};
        System.out.println(satisfied(grid,size));
        System.out.println(satisfied2(grid,size));
    }

    public static int satisfied(int[] grid,int[] size){
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0;
        int si = 0;
        while (gi < grid.length && si < size.length){
            if (grid[gi] <= size[si]){
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static int satisfied2(int[] grid,int[] size){
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = grid.length-1;
        int si = size.length-1;
        int count =0;
        while (gi > -1 && si > -1){
            if (grid[gi] <= size[si]){
                si--;
                count++;
            }
            gi--;
        }
        return count;
    }

    public static void checkArr(int[] arr){
        if (arr.length == 0 || arr == null){
            throw new IllegalArgumentException("数组为零或者为空!");
        }
    }
}
