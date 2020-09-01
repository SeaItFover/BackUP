package 设计模式.代理模式.实现一;

public class ProxyPrinter implements Printable{

    String name;
    Printer printer = null;

    //代理能做的事自己去做
    @Override
    public synchronized void setPrinterName(String name) {
        if (printer != null){
            printer.setPrinterName(name);
        }
        this.name = name;
    }

    //代理能做的事自己去做
    @Override
    public String getPrinterName() {
        return name;
    }

    //代理做不了的交给真正能做的（打印机）去做
    @Override
    public void print(String word) {
        check();
        printer.print(word);
    }

    private synchronized void check(){
        if(printer == null){
            printer = new Printer(name);
        }
    }
}
