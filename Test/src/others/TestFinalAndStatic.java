package others;

/**
 * 1.方法内部不能定义静态变量。因为被static修饰的静态变量从属于类。
 * 2.静态变量可以在定义的时候初始化也可以不初始化。而且静态变量可以修改值。
 * 3.final修饰的常量必须在定义的时候就初始化
 * 4.不能修改一个final修饰的常量的值，因为它在定义的时候就已经初始化了
 * 5.被static final修饰的属性其实并没有什么多大区别，分开来看static 和final就行，
 * static决定了这个变量从属于类，final决定了这是个常量，必须定义的时候就给他赋值
 */
public class TestFinalAndStatic {
    static int i;
    static int j = 1;
    public void setI(){
        i = 2;
    }

    //final int k; //error
    final int m = 1;

    //static final int n; //error
    static final int n = 1;

    public void setM(){
        //m = 2; //error
    }
    public static void main(String[] args) {
        //static int i ;   //error
        j = 2;
        System.out.println(j);
    }
}
