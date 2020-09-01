package 设计模式.工厂方法模式;

/**
 * 工厂方法模式缺点：
 * 以上这种方式，虽然解耦了，也遵循了开闭原则，但是问题根本还是没有解决啊，换汤没换药，
 * 如果我需要的产品很多的话，需要创建非常多的工厂，所以这种方式的缺点也很明显；
 */
public class TestFactory {
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        PearFactory pearFactory = new PearFactory();
        Apple apple = (Apple)appleFactory.createFruit();  //获得苹果
        Pear pear = (Pear)pearFactory.createFruit();       //获得梨
    }
}
