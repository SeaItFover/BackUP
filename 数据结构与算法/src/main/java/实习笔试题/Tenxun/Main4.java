package 实习笔试题.Tenxun;

import java.util.Scanner;
import java.util.Stack;

public class Main4 {
    public static Queue linkedList = new Queue();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            ost(sc.nextLine());
        }
    }

    public static void ost(String s) {
        if (s.contains(" ")){

            String[] str = s.split(" ");
            linkedList.add(Integer.parseInt(str[1]));
        }
        if (s.equals("peek")) {
            System.out.println(linkedList.peek());
        }else if (s.equals("poll")) {
            linkedList.poll();
        }
    }
}

class Queue{
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void add(int e) {
        in.push(e);
    }

    public int size() {
        return in.size() + out.size();
    }

    public int peek() {
        if (out.isEmpty()) {
            return in.firstElement();
        }

        return out.peek();

    }

    public int poll() {
        if (in.isEmpty() && out.isEmpty()) {
            return -1;
        }
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        return out.pop();
    }
}