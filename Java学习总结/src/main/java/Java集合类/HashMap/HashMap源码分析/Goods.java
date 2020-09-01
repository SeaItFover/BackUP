package Java集合类.HashMap.HashMap源码分析;

public class Goods {
    private int id;
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Goods)) {
            return false;
        }

        Goods goods = (Goods) o;

        if (id != goods.id) {
            return false;
        }
        if (Double.compare(goods.price, price) != 0) {
            return false;
        }
        return name != null ? name.equals(goods.name) : goods.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
