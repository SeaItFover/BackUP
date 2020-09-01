package 左神算法.ArrayStackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {
    private Queue<Integer> data;
    private Queue<Integer> help;

    public TwoQueueStack() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(int pushInt) {
        data.add(pushInt);
    }

    public int peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (data.size() != 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        help.add(res);
        swap();
        return res;
    }

    public int pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (data.size() != 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> temp = help;
        help = data;
        data = temp;
    }
}
