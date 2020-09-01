package Java基础语法.Java的三大特性;

/**
 * 如何实现封装
 * 1. 将成员变量用private修饰
 * 2. 提供public方法供外部访问，方法内部进行合理值的判断。
 * 3.  构造方法中使用set方法进行合理值的判断
 */
public class Encapsulation {
    public static void main(String[] args) {

    }
}

class Person{
    private int age;

    public Person(){};

    public Person(int age){
        setAge(age);
    }

    public void setAge (int age){
        if(age>0 && age <=120){
            this.age = age;
        }else{
            System.out.println("输入有误！");
        }
    }

    public int getAge(){
        return this.age;
    }
}
