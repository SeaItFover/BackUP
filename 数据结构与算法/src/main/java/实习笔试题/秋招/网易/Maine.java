package 实习笔试题.秋招.网易;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            long temp = scanner.nextLong();
            list1.add(temp);
            list2.add(temp);
        }
        scanner.close();
        for (int i = 1; i <= n; i++) {
            if (list1.contains((long)i)) {
                continue;
            }
            for (int j = 0; j < list2.size(); j++) {
                if (j == list2.size() - 1 && list2.get(j) < i) {
                    list2.add((long)i);
                }
                if (list2.get(j) > i) {
                    list2.add(j, (long)i);
                    break;
                }
            }
        }
        String res = "";
        for (int i = 0; i < list2.size(); i++) {
            res = res.concat(String.valueOf(list2.get(i))).concat(" ");
        }
        res.trim();
        System.out.println(res);
    }
}
