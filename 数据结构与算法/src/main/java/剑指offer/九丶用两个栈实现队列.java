package 剑指offer;

import java.util.Stack;

public class 九丶用两个栈实现队列 {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int data){
        in.push(data);
    }

    public int pop() throws Exception {
        if (out.empty()){
            while(!in.empty()){
                out.push(in.pop());
            }
        }

        if (out.empty()){
            throw new Exception("Queue is empty");
        }

        return out.pop();
    }

    public static void main(String[] args) throws Exception {
        九丶用两个栈实现队列 nn = new 九丶用两个栈实现队列();
        nn.push(1);
        nn.push(2);
        nn.push(3);
        nn.push(4);
        nn.push(5);
        System.out.println(nn.pop());
    }
}
