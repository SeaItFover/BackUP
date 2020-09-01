package 左神算法.ArrayStackQueue;

import java.util.Stack;

/**
 * 该栈可以返回栈中最小元素
 */
public class SpecialStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public SpecialStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        }else if (newNum < stackMin.peek()) {
            this.stackMin.push(newNum);
        }else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        return this.stackMin.peek();
    }
}
