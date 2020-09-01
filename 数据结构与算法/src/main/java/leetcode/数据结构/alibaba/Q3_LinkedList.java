package leetcode.数据结构.alibaba;

/**
 * LinkedList内部是双向链表，size,isEmpty,clear,get,add,add(index),remove(index)
 * 这几个方法
 *
 * @param <E>
 */
public class Q3_LinkedList<E> {

    //这里first和last分别是头指针和尾指针，我自己觉得链表最核心的就是这两个坐标，有了这两个，后面所有操作都简单了很多
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

    /**
     * get方法首先先检查index是否合法，然后遍历查找对应的位置
     * @param index
     * @return
     */
    public E get(int index) {
        checkElementIndex(index);
        return node(index).e;
    }

    /**
     * add默认尾插法
     * @param e
     * @return
     */
    public boolean add(E e) {
        Node<E> newNode = new Node<>(last, e, null);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
        return true;
    }

    /**
     * remove的逻辑：
     * 首先检查下标是否合法，然后如果它前面元素为空，说明他就是头结点，直接删掉，令头结点为空即可。
     * 否则不是头结点令前继节点指向后继节点，后继节点指向前继节点
     * 这里还需要判断是不是尾节点，因为涉及到尾指针的变动。
     * @param index
     * @return
     */
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Size" + size + "\tIndex" + index);
        }
    }
}
