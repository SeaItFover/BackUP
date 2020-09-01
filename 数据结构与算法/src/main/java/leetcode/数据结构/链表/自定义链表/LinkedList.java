package leetcode.数据结构.链表.自定义链表;


/**
 * LinkedList内部是双向链表，size,isEmpty,clear,get,add,add(index),remove(index)
 * 这几个方法
 *
 * @param <E>
 */
public class LinkedList<E> {

    private int size;
    Node first;
    Node last;

    private class Node<E> {
        Node prev;
        E e;
        Node next;

        public Node(Node prev, E e, Node next) {
            this.prev = prev;
            this.e = e;
            this.next = next;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        //遍历删除每个节点
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.prev = null;
            x.e = null;
            x.next = null;
            x = next;
        }
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public boolean add(int index, E e) {
        //checkElementIndex(index);
        if (index == size){
            linkLast(e);
        }else{
            linkBefore(e, node(index));
        }
        return true;
    }

    public E remove(int index){
        checkElementIndex(index);
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        E e = node.e;
        if (prev == null){
            first = next;
        }else{
            prev.next = next;
            node.prev = null;
        }
        if (next == null){
            last = prev;
        }else{
            next.prev = prev;
            node.next = null;
        }
        return e;
    }

    private void linkBefore(E e, Node<E> node) {
        Node<E> newNode = new Node<>(node.prev,e,node);
        if (node.prev == null){
            first = newNode;
        }else{
            node.prev.next = newNode;
        }
        node.prev = newNode;
        size++;
    }

    private void linkLast(E e) {
        Node<E> newNode = new Node<>(last, e, null);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public E get(int index) {
        //checkElementIndex(index);
        return node(index).e;
    }

    //根据索引找到对应的节点（这里采用二分查找提高一定的性能）
    private Node<E> node(int index) {
        //checkElementIndex(index);
        if (index < (size >> 2)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }

    }

    private void checkElementIndex(int index) {
        if (index >= 0 && index < size) {
            throw new IndexOutOfBoundsException("Size" + size + "\tIndex" + index);
        }
    }
}
