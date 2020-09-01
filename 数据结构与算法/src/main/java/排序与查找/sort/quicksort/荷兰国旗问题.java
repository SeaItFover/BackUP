package 排序与查找.sort.quicksort;

import java.util.Arrays;
import java.util.Comparator;

public class 荷兰国旗问题 {

    static class User {
        int id;
        String name;
    }

    public static void main(String[] args) {
        User user = new User();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User[] users = new User[]{user, user1, user2};
        Arrays.sort(users, Comparator.comparingInt(u -> u.id));
    }

    public static int[] partition(int[] arr, int L, int R, int num) {

        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < num) {
                swap(arr, ++less, L++);
            } else if (arr[L] > num) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        //返回数组是等于区域的下标
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
