package Java集合类.HashMap.HashMap源码分析;

import java.util.List;

public class Cart {
    private int userId;
    private List<Goods> cartList;

    public Cart() {
    }

    public Cart(int userId, List<Goods> cartList) {
        this.userId = userId;
        this.cartList = cartList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Goods> getCartList() {
        return cartList;
    }

    public void setCartList(List<Goods> cartList) {
        this.cartList = cartList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cart)) {
            return false;
        }

        Cart cart = (Cart) o;

        if (userId != cart.userId) {
            return false;
        }
        return cartList != null ? cartList.equals(cart.cartList) : cart.cartList == null;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (cartList != null ? cartList.hashCode() : 0);
        return result;
    }
}
