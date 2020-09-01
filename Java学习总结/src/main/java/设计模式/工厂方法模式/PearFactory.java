package 设计模式.工厂方法模式;

public class PearFactory implements FruitFactory {
    @Override
    public Fruit createFruit() {
        return new Pear();
    }
}
