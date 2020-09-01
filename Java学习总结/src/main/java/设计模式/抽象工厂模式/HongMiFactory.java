package 设计模式.抽象工厂模式;

/**
 * 以上例子可以看出，抽象工厂可以解决一系列的产品生产的需求，
 * 对于大批量，多系列的产品，用抽象工厂可以更好的管理和扩展；
 */
public class HongMiFactory implements PhoneFactory{
    @Override
    public Cpu getCpu() {
        return new Cpu.Cpu650();
    }

    @Override
    public Screen getScreen() {
        return new Screen.Screen5();
    }
}
