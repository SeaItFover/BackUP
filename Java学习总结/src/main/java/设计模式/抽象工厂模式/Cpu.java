package 设计模式.抽象工厂模式;

/**
 * 所考虑问题:
 * 定义：为创建一组相关或者是相互依赖的对象提供的一个接口，而不需要指定它们的具体类。
 * 角色：和工厂方法一样
 * 抽象工厂和工厂方法的模式基本一样，区别在于，工厂方法是生产一个具体的产品，
 * 而抽象工厂可以用来生产一组相同，有相对关系的产品；重点在于一组，一批，一系列；
 * 举个例子，假如生产小米手机，小米手机有很多系列，小米note、红米note等；
 * 假如小米note生产需要的配件有825的处理器，6英寸屏幕，而红米只需要650的处理器和5寸的屏幕就可以了；
 * 用抽象工厂来实现：
 */
public interface Cpu {
    void run();

    class Cpu650 implements Cpu{

        @Override
        public void run() {
            //625
        }
    }

    class Cpu825 implements Cpu{

        @Override
        public void run() {
            //825
        }
    }
}
