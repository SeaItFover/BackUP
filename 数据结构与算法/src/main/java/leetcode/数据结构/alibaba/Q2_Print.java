package leetcode.数据结构.alibaba;

import java.util.Scanner;

public class Q2_Print {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        String res = "";
        for (int i = strings.length - 1; i >= 0; i--) {
            if (i != 0) {
                res += strings[i] + " ";
            } else {
                res += strings[i];
            }
        }
        System.out.println(res);
    }
}
