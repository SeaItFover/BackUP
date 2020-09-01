package Java基础语法.常用类;

/**
 * ArrayS类常用方法:
 * toString() copyOf() fill() sort() binartSearch() asList()
 */
public class ArraysClass {
    public static void main(String[] args) {
        int[] arr = new int[3];
        java.util.Arrays.fill(arr,2);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
