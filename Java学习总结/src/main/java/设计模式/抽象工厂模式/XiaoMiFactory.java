package 设计模式.抽象工厂模式;

/**
 * 具体工厂实现类：小米手机工厂
 */
public class XiaoMiFactory implements PhoneFactory{
    @Override
    public Cpu getCpu() {
        return new Cpu.Cpu825();
    }

    @Override
    public Screen getScreen() {
        return new Screen.Screen6();
    }
}
