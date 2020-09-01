package 设计模式.代理模式.实现一;

/**
 * 此类相当于本人（真正的服务器）
 */
public class Printer {

    String name;
    public Printer(String name){
        this.name = name;
        heavyWork();
        System.out.println("生成打印机实例成功...");
    }

    //做一些重活
    private void heavyWork(){
        System.out.println("本人："+name);
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void setPrinterName(String name){
        this.name = name;
    }

    public String getPrinterNamw(){
        return name;
    }

    public void print(String word){
        System.out.println("打印机" + name + "正在打印....");
        System.out.println(word);
        System.out.println("打印完成！");
    }

}
