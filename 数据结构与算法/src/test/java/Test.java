import java.util.ArrayList;
import java.util.List;

public class Test {

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,6,4,7,1,9,4};
        System.out.println(getSum(arr, 5));
    }

    public static List<List<Integer>> getSum(int[] arr, int sum) {
        dfs(arr, sum, 0, 0, new ArrayList<>());
        return res;
    }

    public static void dfs(int[] arr, int sum, int index, int cur, List list) {
        if (index == arr.length && cur != sum) {
            return;
        }
        if (index == arr.length && cur == sum) {
            res.add(list);
            return;
        }
        List<Integer> newArr = new ArrayList<>(list);
        newArr.add(arr[index]);
        dfs(arr, sum, index + 1, cur + arr[index], newArr);
        dfs(arr, sum, index + 1, cur, list);
    }
}
