package leetcode.数据结构.alibaba;

/**
 * 饿汉式单例：在第一次使用的时候才会创建单例对象，但是它存在线程安全问题：
 * 解决方案有两种：使用静态内部类的方式  或者  使用DCL的方式
 * 我这里使用了DCL的方式；首先第一重检查是避免线程直接陷入争抢锁的逻辑，加一个非空判断提高效率
 * 第二重判断是为了避免重复创建对象的问题：比如有两个线程同时进入第一个逻辑之后，第一个抢到锁的线程创建了实例，第二个在抢到之后再一次重复创建锁。
 * DCL在jdk使用：我在学习jvm类加载的时候，看到sun.misc.launcher中获取ext类加载器使用到了。
 * volatile的作用：这里是为了禁止指令重排序，因为创建对象有几个步骤：申请空间、创建实例、赋值引用。如果二三步重排序的话，会导致对象创建不完全，其他线程
 * 可能获取到不完整的对象。
 */
public class Q1_Singleton02 {

    private static volatile Q1_Singleton02 instance;

    private Q1_Singleton02() {}

    public static Q1_Singleton02 getInstance() {
        if (instance == null) {
            synchronized (Q1_Singleton02.class) {
                if (instance == null) {
                    instance = new Q1_Singleton02();
                }
            }
        }
        return instance;
    }
}
