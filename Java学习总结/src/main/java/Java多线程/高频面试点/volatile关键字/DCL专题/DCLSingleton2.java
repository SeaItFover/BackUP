package Java多线程.高频面试点.volatile关键字.DCL专题;

/**
 * 另一个线程安全的DCL是使用静态内部类的方式
 */
public class DCLSingleton2 {
    private DCLSingleton2 (){}

    static class inner{
        private static DCLSingleton2 instance = new DCLSingleton2();;
    }

    public static DCLSingleton2 getInstance(){
        return inner.instance;
    }

}
