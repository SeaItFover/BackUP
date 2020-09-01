package leetcode.算法思想;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 总结：map操作一定要在node操作之前
 * put和get方法都会导致新的节点放在头部
 * put的时候
 */
public class LRUCache {

    public static void main(String[] args) {
        Stream.of(new int[2]).collect(Collectors.toList());

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    class Node {
        int key;
        int value;

        private Node prev;
        private Node next;

        private Node(){}

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
        size++;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
        //return node;
    }

    //每次get一个节点后，需要将该节点放在链表头部
    private void moveNodeToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node head;
    private Node tail;
    private int capicity;
    private int size;
    private HashMap<Integer, Node> cache;

    public LRUCache(int capicity) {
        this.capicity = capicity;
        cache = new HashMap<>(capicity);
        head = new Node();
        tail = new Node();

        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveNodeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        //Node node = new Node(key,value); //error这里的节点是取出来的，不是新建的节点
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            /*if (size < capicity){
                cache.put(key,newNode);
                addNode(newNode);
            }else {
                removeNode(tail.prev);
                cache.put(key,newNode);
                addNode(newNode);
            }*/
            cache.put(key,newNode);
            addNode(newNode);
            if (size > capicity) {
                // pop the tail
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
            }
        } else {
            node.value = value;
            moveNodeToHead(node);
        }
    }
}
