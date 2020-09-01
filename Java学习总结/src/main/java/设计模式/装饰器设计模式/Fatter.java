package 设计模式.装饰器设计模式;
interface Weight{
    void getWeight();
}

class People implements Weight{
    String name;
    int weight;

    public People(){};

    public People(String name,int weight){
        this.weight = weight;
        this.name = name;
    }

    @Override
    public void getWeight() {
        System.out.println("我是一个胖子，我的体重是-->"+this.weight);
    }
}

class Pig implements Weight{
    People people = new People();

    public Pig(People p){
        this.people = p;
    }

    @Override
    public void getWeight() {
        System.out.println("经过猪的喂养，我的体重是-->"+(this.people.weight+20));
    }
}

public class Fatter {
    public static void main(String[] args) {
        People people = new People("spu",60);
        people.getWeight();
        Pig pig = new Pig(people);
        pig.getWeight();
    }
}
