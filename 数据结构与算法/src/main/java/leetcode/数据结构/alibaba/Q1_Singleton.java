package leetcode.数据结构.alibaba;

/**
 * 懒汉式单例模式：在类加载的时候就随之被创建出来了，因此是线程安全的，但是有一个问题就是，如果我们一直不使用的话，可能会导致浪费空间。
 */
public class Q1_Singleton {

    private static Q1_Singleton instance = new Q1_Singleton();

    private Q1_Singleton(){}

    public static Q1_Singleton getInstance() {
        return instance;
    }
}
