package 设计模式.原型模式;

/**
 * 以前新建一模一样的对象，需要不停的操作；
 * 现在只需要克隆
 */
public class Test1 {
    public static void main(String[] args) {
        /*Sheep sheep0 = new Sheep("懒羊羊",12,"blue");
        Sheep sheep1 = new Sheep(sheep0.getName(),sheep0.getAge(),sheep0.getColor());
        Sheep sheep2 = new Sheep(sheep0.getName(),sheep0.getAge(),sheep0.getColor());
        Sheep sheep3 = new Sheep(sheep0.getName(),sheep0.getAge(),sheep0.getColor());
        Sheep sheep4 = new Sheep(sheep0.getName(),sheep0.getAge(),sheep0.getColor());
        for (int i = 0;i<5;i++){
            String s = "sheep"+i;
            System.out.println(s);
        }*/
        Sheep sheep0 = new Sheep("懒羊羊",12,"blue");
        System.out.println(sheep0.clone());

    }
}
