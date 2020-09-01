package 基本数据结构的实现.图.demo01;

/**
 * 一个简单的无向图
 */
public class Vertex {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Vertex(String value) {
        this.value = value;
    }
}
