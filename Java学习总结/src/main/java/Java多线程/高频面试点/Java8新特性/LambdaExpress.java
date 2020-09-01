package Java多线程.高频面试点.Java8新特性;

@FunctionalInterface
interface Foo {
    int add(int a, int b);

    default int div(int a, int b) {
        System.out.println("接口中的默认实现方法");
        return a / b;
    }

    static int mv(int x, int y) {
        System.out.println("接口中的静态方法实现");
        return x * y;
    }
}

//Person p = new Person();一个类的构造方法，new接口其实就是匿名内部类
public class LambdaExpress {
    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public int add(int a,int b) {
                System.out.println("匿名内部类");
                return 1;
            }
        };
        System.out.println(foo.add(2,1));
        System.out.println(foo.div(4, 2));
        Foo.mv(44,3);
        //这里foo2和上面的foo一样都是接口Foo的两个实现类的两个实例对象
        //我们要对其进行方法调用的话，和之前学习过的Java基础一样
        Foo foo2 = (a,b) -> {
            System.out.println("Lambda Express");
            return 2;
        };
        System.out.println(foo2.add(2,1));
        System.out.println(foo2.div(4, 2));
        System.out.println(Foo.mv(2, 2));

    }
}