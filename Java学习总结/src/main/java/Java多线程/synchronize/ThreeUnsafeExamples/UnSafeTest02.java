package Java多线程.synchronize.ThreeUnsafeExamples;

/**
 * 线程不安全：取钱
 */
public class UnSafeTest02 {
    public static void main(String[] args) {
        Account account = new Account(100,"marry");
        Drawing you = new Drawing(account,80,"sad me");
        Drawing wife = new Drawing(account,90,"happy her");
        you.start();
        wife.start();
    }
}

class Account{
    int money;
    String name;

    public Account(int money, String name){
        this.money = money;
        this.name = name;
    }
}

//模拟取款
class Drawing extends Thread{
    //用面向对象的思维加几个属性
    Account account;   //取钱的账户
    int drawingMoney;  //取的钱数
    int packetTotal;  //口袋里钱的总数

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        synchronized (account){
            if (account.money-drawingMoney < 0){
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            packetTotal += drawingMoney;

            System.out.println(this.getName()+"账户余额为:"+account.money);
            System.out.println(this.getName()+"口袋里的钱:"+packetTotal);
        }

    }
}