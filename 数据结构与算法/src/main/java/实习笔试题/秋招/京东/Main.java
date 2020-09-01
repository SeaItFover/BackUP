package 实习笔试题.秋招.京东;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int i = 1;
        while (n > 0) {
            n -= Math.pow(3, i);
            if (n <= 0) {
                break;
            }
            i++;
        }
        n += Math.pow(3, i);
        String res = "";
        for (int j = 1; j <= i; j++) {
            if (n <= Math.pow(3, i - j)) {
                res = res.concat(String.valueOf(2));
            } else if (n <= 2 * Math.pow(3, i - j)) {
                res = res.concat(String.valueOf(3));
            }else {
                res = res.concat(String.valueOf(5));
            }
            n = n % Math.pow(3, i - j) == 0 ? n : (int) (n % Math.pow(3, i - j));
        }
        System.out.println(Integer.valueOf(res));
    }
}
