package Java虚拟机.类加载器;

import java.io.*;

public class CustomizeClassLoader extends ClassLoader{

    private final static String fileSuffixExt = ".class";

    private String classLoaderName;

    private String loadPath;

    public void setLoadPath(String loadPath) {this.loadPath =  loadPath;}

    public CustomizeClassLoader(ClassLoader parent, String classLoaderName) {
        /**
         * 指定当前类加载器的父类加载器
         */
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public CustomizeClassLoader(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public CustomizeClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    /**
     * 把我们的文件名变成byte数组。
     * 创建指定class的二进制名称
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        InputStream is = null;

        try{
            name = name.replace(".","\\");
            String fileName = loadPath + name + fileSuffixExt;
            File file = new File(fileName);
            is = new FileInputStream(file);

            baos = new ByteArrayOutputStream();
            int ch;
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != baos) {
                    baos.close();
                }
                if (null != is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    protected Class<?> findClass(String name) {
        byte[] data = loadClassData(name);
        System.out.println("CustomizeClassLoader 加载该类" + name);
        //把我们的二进制数据转化为class对象
        return defineClass(name, data, 0, data.length);
    }
}
