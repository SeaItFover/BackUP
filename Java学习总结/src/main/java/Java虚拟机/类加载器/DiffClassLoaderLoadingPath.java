package Java虚拟机.类加载器;
class Person{

}
public class DiffClassLoaderLoadingPath {

    public static void main(String[] args) {
        Person person = new Person();
        bootStrapPath();
        extClassLoaderPath();
        appClassLoaderPath();
    }

    public static void bootStrapPath() {
        String[] path = System.getProperty("sun.boot.class.path").split(";");
        for (String s : path) {
            System.out.println("启动类加载器：" + s);
        }
    }

    public static void extClassLoaderPath() {
        String[] path = System.getProperty("java.ext.dirs").split(";");
        for (String s : path) {
            System.out.println("扩展类加载器：" + s);
        }
    }

    public static void appClassLoaderPath() {
        String[] path = System.getProperty("java.class.path").split(";");
        for (String s : path) {
            System.out.println("app加载器：" + s);
        }
    }
}
