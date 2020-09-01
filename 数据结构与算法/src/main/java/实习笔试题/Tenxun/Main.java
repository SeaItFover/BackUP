package 实习笔试题.Tenxun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static LinkedList<Object> linkedList = new LinkedList<>();

    private static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(sc.nextLine());
            for (int j = 0; j < t; j++){
                ope(sc.nextLine());
            }
        }
       /* for (Object o : list) {
            System.out.println(o);
        }*/
    }

    public static void ope(String s) {
        if (s.contains(" ")){
            String[] str = s.split(" ");
            linkedList.add(str[1]);
        }
        if (s.equals("TOP")) {
            if (linkedList.size() == 0) {
                //list.add(-1);
                System.out.println(-1);
            }else {
                //list.add(linkedList.getFirst());
                System.out.println(linkedList.getFirst());
            }
            //System.out.println(linkedList.getFirst());
        }else if (s.equals("POP")) {
            if (linkedList.size() == 0) {
                //list.add(-1);
                System.out.println(-1);
            }else {
                linkedList.removeFirst();
            }
        }else if (s.equals("SIZE") ) {
            //list.add(linkedList.size());
            System.out.println(linkedList.size());
        }else if (s.equals("CLEAR")) {
            linkedList.clear();
        }
    }
}
