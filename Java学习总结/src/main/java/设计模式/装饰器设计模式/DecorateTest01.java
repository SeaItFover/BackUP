package 设计模式.装饰器设计模式;

/**
 * 抽象组件、具体组件
 * 抽象装饰器、具体装饰器
 */
interface Drink{
    void price();
}

class Coffee implements Drink{

    @Override
    public void price() {
        System.out.println();
    }
}

class Decorate{
    String name;

}

class Milk extends Decorate{

}

public class DecorateTest01 {
    public static void main(String[] args) {

    }
}
