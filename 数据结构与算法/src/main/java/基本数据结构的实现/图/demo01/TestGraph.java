package 基本数据结构的实现.图.demo01;

import java.util.Arrays;

public class TestGraph {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");
        Graph g = new Graph(5);
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addEdge(v1,v3);
        g.addEdge(v2,v3);
        g.addEdge(v1,v2);
        g.addEdge(v2,v4);
        g.addEdge(v2,v5);

        for (int[] a:g.adjMatix){
            System.out.println(Arrays.toString(a));
        }
    }

}
