package 设计模式.简单工厂模式;

/**
 * 简单工厂模式存在的问题：
 * 对，那就是如果我想吃香蕉，想吃橘子呢，我万一什么都想吃呢？？
 * 所以，以上的这种方式，每当我想添加一种水果，就必然要修改工厂类，这显然违反了开闭原则，亦不可取；
 * 所以简单工厂只适合于产品对象较少，且产品固定的需求，对于产品变化无常的需求来说显然不合适；
 */
public class TestFactory {
    public static void main(String[] args) {
        FruitFactory ff = new FruitFactory();
        Apple apple = (Apple)ff.createFruit("pear");
    }
}
