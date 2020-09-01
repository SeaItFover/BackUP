package 基本数据结构的实现.图;

import java.util.Arrays;

public class TestSort implements Comparable{

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,9,5,1,0};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    @Override
    public int compareTo(Object o) {
        int obj = (Integer)o;
        return 0;
    }
}
