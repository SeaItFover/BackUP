package 设计模式.单例设计模式;

/**
 * 单例模式：懒汉式套路的基础下加入并发，保证在多线程环境下，对外存在一个对象
 * 1、构造器私有化-->避免外部new构造器
 * 2、提供私有的静态属性-->存储对象的地址
 * 3、提供公有的静态方法-->获取属性
 *
 * 双重检测
 *
 * new一个对象会做三件事情
 * 1.开辟空间
 * 2.初始化对象信息
 * 3.返回对象的地址给引用
 */
public class DoubleCheckedLocking {

    //2.提供私有的静态属性
    private static DoubleCheckedLocking instance;

    //1.构造器私有化
    private DoubleCheckedLocking(){}

    //3.提供公有的静态方法-->获取属性
    public static DoubleCheckedLocking getInstance(){
        //再次检测
        if(null != instance){//避免不必要的同步
            return instance;
        }
        synchronized (DoubleCheckedLocking.class){
            if (instance == null){
                instance = new DoubleCheckedLocking();
            }
        }
        return instance;
    }

}
