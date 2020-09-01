package Java虚拟机.类加载器.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class MainClass {
    public static void main(String[] args) {

    }

    public static void testSPI() {
        //1.把我们的接口类型保存到ServiceLoader变量中
        //2.创建一个我们懒加载的迭代器
        ServiceLoader<IParseDoc> iParseDocs = ServiceLoader.load(IParseDoc.class);

        //返回我们的懒加载的迭代器对象
        Iterator<IParseDoc> iParseDocIterator = iParseDocs.iterator();
        while (iParseDocIterator.hasNext()) {
            iParseDocIterator.next().parse();
        }
    }
}
