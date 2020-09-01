package Test;

import org.springframework.beans.factory.BeanNameAware;

public class Spring implements BeanNameAware {

    String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

    }
}
