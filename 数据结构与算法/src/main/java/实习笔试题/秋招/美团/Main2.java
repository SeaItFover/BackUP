package 实习笔试题.秋招.美团;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        int l = str.indexOf("T");
        int r = str.lastIndexOf("M");
        System.out.println(str.substring(l + 1, r));
    }
}
