package others;

public class TestStaticVariable {
    public static void main(String[] args) {
        Test02.d = 2;
        System.out.println(Test02.d);
        System.out.println(Test02.d);
    }
}
class Test02{
    public static int d = 22;
}