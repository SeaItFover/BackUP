package Java虚拟机;
interface Foo{
    public int add(int a, int b);

    default int div(int a, int b){
        System.out.println("接口中的默认方法");
        return a/b;
    }
    static int mv(int a, int b){
        System.out.println("接口中的静态方法实现");
        return a * b;
    }
}

public class 测试运行时常量池 {
    public static String ss = "dsfa干活";
    public static void main(String[] args) {
        Foo foo1 = new Foo(){
            @Override
            public int add(int a,int b){
                System.out.println("匿名内部类");
                return a + b;
            }
        };
        System.out.println(foo1.add(2, 1));
        System.out.println(foo1.div(4, 2));
        System.out.println(Foo.mv(1, 3));

        Foo foo2 = (a,b) -> a+b;
        System.out.println(foo2.add(4, 2));

        System.out.println("护肤老师");
        String s = new String("的说法");
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println((double)Runtime.getRuntime().totalMemory()/1024/1024);
    }
}
