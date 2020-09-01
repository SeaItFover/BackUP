package Java多线程.synchronize.ThreeSafeExamples;

/**
 * 同步块
 */
public class SynBlock01 {
    public static void main(String[] args) {
        Account account = new Account(100,"marry");
        SynDrawingMoney you = new SynDrawingMoney(account,80,"sad you");
        SynDrawingMoney wife = new SynDrawingMoney(account,90,"happy your wife");
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

class SynDrawingMoney extends Thread{
    private Account account;
    private int drawingMoney;
    private String name;

    public SynDrawingMoney(Account account,int drawingMoney,String name){
        this.account = account;
        this.drawingMoney = drawingMoney;
        this.name = name;
    }

    @Override
    public void run() {
        if (account.money <= 0 ){
            return;
        }
        synchronized (account){
            if (account.money - drawingMoney <= 0){
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;

            System.out.println("账户余额为："+account.money);
            System.out.println(name+"取了"+drawingMoney+"钱");
        }
    }
}