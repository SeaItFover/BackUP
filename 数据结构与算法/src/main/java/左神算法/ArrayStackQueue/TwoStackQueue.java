package 左神算法.ArrayStackQueue;

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public TwoStackQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int pushInt) {
        in.push(pushInt);
    }

    public int poll() {
        if (out.isEmpty() && in.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty() && in.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
}
