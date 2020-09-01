package 排序与查找.sort.bubblesort;

import java.util.Arrays;

//f方法内部的使用
public class TestConstructorRef {
    public static void main(String[] args) {
        int[] arr = new int[] {23,32,245,435,324,5,32,56,32,4};
        String[] strings = new String[]{"23","3241","324"};
        Integer[] integers = Arrays.stream(arr).boxed().toArray(Integer[]::new);//.collect(Integer[]::new);
        System.out.println(integers[0] instanceof Integer);
    }
}
