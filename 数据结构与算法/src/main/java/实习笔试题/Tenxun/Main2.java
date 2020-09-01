package 实习笔试题.Tenxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(sc.nextLine());
            String[] str = new String[2 * t];
            for (int j = 0; j < 2 * t; j++) {
                str[j] = sc.nextLine();
            }
            res.add(res(str,t));
            //System.out.println(res(str, t));
        }
        for (String re : res) {
            System.out.println(re);
        }
    }

    public static String res(String[] str, int t) {
        double max = Double.MAX_VALUE;
        for (int i = 0; i < t; i++) {
            for (int j = t; j < 2 * t; j++){
                String[] is = str[i].split(" ");
                String[] js = str[j].split(" ");
                double a = Math.pow((Double.parseDouble(is[0]) - Double.parseDouble(js[0])), 2) + Math.pow((Double.parseDouble(is[1]) - Double.parseDouble(js[1])), 2);
                double h = Math.sqrt(a);
                max = Math.min(max, h);
            }
        }
        return String.format("%.3f", max);
    }
}
