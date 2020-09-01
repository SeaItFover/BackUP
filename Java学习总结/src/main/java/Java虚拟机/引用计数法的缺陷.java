package Java虚拟机;

/**       SoftReference;
        WeakReference;
        PhantomReference*/

public class 引用计数法的缺陷 {
    public Object instance ;

    private final static int _1MB = 1024*1024;

    private byte[] bigSize = new byte[3 * _1MB];


    public static void main(String[] args ) {
        引用计数法的缺陷 objA = new 引用计数法的缺陷();
        引用计数法的缺陷 objB = new 引用计数法的缺陷();
        objA.instance = objB;
        objB.instance = objA;


        objA = null;
        objB = null;

        System.gc();
    }

}
