package Java虚拟机.类文件结构;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * java.lang.invoke包就是方法句柄
 * 其下包含两个重要的类MethodType And MethodHandler
 */
public class MethodHandlerTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
        MethodType methodType = MethodType.methodType(String.class, int.class);
        System.out.println(methodType);
        MethodHandle constructor = MethodHandles.lookup().findVirtual(MethodHandlerTest.class,"f1", methodType);
        System.out.println(constructor);
    }

    public String f1(int a) {
        System.out.println("f1" + a);
        return a+"";
    }

    public void f2() {
        System.out.println("f2");
    }

    public static void f3() {
        System.out.println("f3");
    }

}
