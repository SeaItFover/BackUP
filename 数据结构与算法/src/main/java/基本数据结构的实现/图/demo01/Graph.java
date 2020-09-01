package 基本数据结构的实现.图.demo01;

public class Graph {
    private Vertex[] vertex;
    public int[][] adjMatix;
    private int currentIndex;

    public Graph(int size){
        this.vertex = new Vertex[size];
        adjMatix = new int[size][size];
        for (int i = 0; i<size; i++){
            adjMatix[i][i] = 1;
        }
    }

    public void addVertex(Vertex v){
        vertex[currentIndex++] = v;
    }

    public void addEdge(Vertex v1, Vertex v2){
        int index1 = 0;
        for (int i = 0; i<vertex.length; i++){
            if (v1.getValue().equals(vertex[i].getValue())){
                index1 = i;
                System.out.println(i);
                break;
            }
        }
        int index2 = 0;
        for (int i = 0; i<vertex.length; i++){
            if (v2.getValue().equals(vertex[i].getValue())){
                index2 = i;
                System.out.println(i);
                break;
            }
        }
        adjMatix[index1][index2] = 1;
        adjMatix[index2][index1] = 1;
    }
}
