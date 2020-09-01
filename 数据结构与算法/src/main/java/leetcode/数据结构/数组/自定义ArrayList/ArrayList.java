package leetcode.数据结构.数组.自定义ArrayList;

import java.util.Arrays;

public class ArrayList<E> {
    private final static Object[] DEFAULT_EMPTY_CAPICITY = {};
    private final static Object[] EMPTY_CAPICCITY = {};
    private final static int DEFAULT_CAPICITY = 10;
    private int size;
    private Object[] elementData;

    public ArrayList() {
        elementData = DEFAULT_EMPTY_CAPICITY;
    }

    public ArrayList(int initialCapicity) {
        if (initialCapicity > 0) {
            elementData = new Object[initialCapicity];
        } else if (initialCapicity == 0) {
            elementData = EMPTY_CAPICCITY;
        } else {
            throw new IllegalArgumentException("Illegal initialCapicity" + initialCapicity);
        }
    }

    //size,isEmpty,get,add,add(E e,int index),remove
    public boolean add(E e) {
        ensureCapicityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    public void add(int index, E e) {
        checkAddIndex(index);
        ensureCapicityInternal(size + 1);
        System.arraycopy(elementData,index,elementData,index+1,size - index);
        elementData[index] = e;
        size++;
    }
    //请空之后需要将最后面的元素置为null
    public E remove(int index){
        E e = (E) elementData[index];
        System.arraycopy(elementData,index+1,elementData,index,size-index-1);
        elementData[--size] = null;
        return e;
    }

    private void checkAddIndex(int index) {
        if (index <= 0 || index > size) {
            throw new IllegalArgumentException("index"+","+index);
        }
    }

    public void ensureCapicityInternal(int minCapicity) {
        ensureExplicitCapicity(calculateCapicity(elementData, minCapicity));
    }

    //始终分析清楚size和数组长度的区别
    //什么时候扩容：当最小容量大于数组长度的时候
    public void ensureExplicitCapicity(int minCapicity) {
        if (minCapicity - elementData.length > 0) {
            grow(minCapicity);
        }
    }

    //不动明王心
    public void grow(int minCapicity) {
        //注意：这里的老容量不是minCapicity，而是数组长度，因为是对数组扩容
        int oldCapicity = elementData.length;
        int newCapicity = oldCapicity + oldCapicity >> 1;
        if (newCapicity - minCapicity < 0) {
            newCapicity = minCapicity;
        }
        elementData = Arrays.copyOf(elementData, newCapicity);
    }

    //这一步就是为了初始化的时候数组容量为10，而不是空
    private int calculateCapicity(Object[] elementData, int minCapicity) {
        if (elementData == DEFAULT_EMPTY_CAPICITY) {
            minCapicity = Math.max(DEFAULT_CAPICITY, minCapicity);
        }
        return minCapicity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index" + "," + index);
        }
    }

}
