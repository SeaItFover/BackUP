package Java虚拟机.类加载器.spi;

public class ExcelParse implements IParseDoc {
    @Override
    public void parse() {
        System.out.println("Excel");
    }
}
