package others;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class 利用反射越过泛型检测 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> list = new ArrayList<>();
        list.add("ss");
        //list.add(1);
        Class clazz = Class.forName("java.util.ArrayList");
        Method m = clazz.getMethod("add",Object.class);
        m.invoke(list,1);
        System.out.println(list);
    }
}
