package Java虚拟机.类加载器;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        CustomizeClassLoader customizeClassLoader = new CustomizeClassLoader("customizeClassLoader");
        customizeClassLoader.setLoadPath("D:\\JAVA\\Idea\\Project\\Java学习总结\\target\\classes\\Java虚拟机\\类加载器\\");
        Class<?> clazz = customizeClassLoader.loadClass("Person");
        //Class<?> clazz = customizeClassLoader.    loadClass("D:\\JAVA\\Idea\\Project\\Java学习总结\\target\\classes\\Java虚拟机\\类加载器");
        System.out.println(clazz.getClassLoader());

    }
}
