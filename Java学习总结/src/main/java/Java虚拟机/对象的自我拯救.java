package Java虚拟机;

/**
 * 对象的finalize是自我拯救的最后一次机会，但是只会被执行一次。
 */
public class 对象的自我拯救 {
    private static 对象的自我拯救 SAVE_HOOK = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize is executed");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new 对象的自我拯救();

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            System.out.println("I am still alive");
        }else{
            System.out.println("i am dead");
        }

       // SAVE_HOOK = new 对象的自我拯救();

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            System.out.println("I am still alive");
        }else{
            System.out.println("i am dead");
        }
    }
}
