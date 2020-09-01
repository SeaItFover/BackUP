package 实习笔试题.秋招.京东;

public class ArrayToQueue {

    Integer[] arr;
    int start;
    int end;
    int size;

    public ArrayToQueue(int cap) {
        if (cap < 0) {
            throw new RuntimeException("");
        }
        arr = new Integer[cap];
        start = 0;
        end = 0;
        size = 0;
    }

    public void push(int val) {
        if (size == arr.length) {
            throw new RuntimeException("");
        }
        size++;
        arr[end] = val;
        end = end == arr.length - 1 ? 0 : end + 1;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[start];
    }

    public Integer pop() {
        if (size == 0) {
            throw new RuntimeException("");
        }
        size--;
        int temp = start;
        start = start == arr.length - 1 ? 0 : start + 1;
        return arr[temp];
    }

    public static void main(String[] args) {
        ArrayToQueue arrayToQueue = new ArrayToQueue(3);
        arrayToQueue.push(1);
        arrayToQueue.push(2);
        arrayToQueue.push(3);
        System.out.println(arrayToQueue.peek());
        System.out.println(arrayToQueue.pop());
        System.out.println(arrayToQueue.peek());
    }
}
