package Java多线程.synchronize.HappyInstance;

/**
 * 快乐影院
 */
public class HappyCinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(100,"sort");
        new Thread(new Customer(cinema,2),"me").start();
        new Thread(new Customer(cinema,1),"sun").start();
    }
}

class Customer implements Runnable{

    Cinema cinema;
    int seats;

    public Customer (Cinema cinema, int seats){
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized(cinema){
            boolean flag = cinema.bookTickets(seats);
            if (flag){
                System.out.println("恭喜"+Thread.currentThread().getName()+"出票成功！");
            }else{
                System.out.println("出票失败！");
            }
        }

    }
}

class Cinema{
    int available;
    String name;

    public Cinema(int available,String name){
        this.available = available;
        this.name = name;
    }
    //购票
    public boolean bookTickets(int seats){
        System.out.println("可用位置有"+available);
        if (seats > available){
            return false;
        }
        available -= seats;
        return true;
    }
}
