package 实习笔试题.秋招.京东;

import java.util.Stack;

public class MinStack {

    Stack<Integer> data;
    Stack<Integer> min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        if (min.isEmpty()) {
            min.push(val);
        } else if (val < min.peek()) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
        data.push(val);
    }

    public Integer getMin() {
        if (min.isEmpty()) {

        }
        return min.peek();
    }

    public Integer pop() {
        if (min.isEmpty()) {

        }
        min.pop();
        return data.pop();
    }
}
