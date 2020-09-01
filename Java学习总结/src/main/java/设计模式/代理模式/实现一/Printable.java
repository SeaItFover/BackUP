package 设计模式.代理模式.实现一;

public interface Printable {

    void setPrinterName(String name);
    String getPrinterName();
    void print(String word);
}
