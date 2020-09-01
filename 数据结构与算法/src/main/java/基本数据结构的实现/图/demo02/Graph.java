package 基本数据结构的实现.图.demo02;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 图的两个要点：顶点和边
 * 顶点存储用什么，边存储用什么
 */
public class Graph {

    //一个用来存储顶点的数组
    String[] vertex;
    //一个用来存储边的二维数组，也即邻接矩阵
    int[][] adjMat;
    int numsOfVertex;
    boolean[] isVisited;

    public Graph(int size){
        vertex = new String[size];
        adjMat = new int[size][size];
        isVisited = new boolean[size];
    }

    //添加顶点
    public void addVertex(String point){
        vertex[numsOfVertex++] = point;
    }

    /**
     * v1和v2之间添加边，也即邻接矩阵对应位置为1
     * @param v1 顶点1
     * @param v2 顶点2
     */
    public void addEdges(String v1,String v2){
        //找到顶点1在顶点数组中的位置
        int index1 = 0;
        for (int i = 0; i < vertex.length; i++){
            if (vertex[i].equals(v1)){
                index1 = i;
            }
        }
        //找到顶点2在顶点数组中的位置
        int index2 = 0;
        for (int i = 0; i < vertex.length; i++){
            if (vertex[i].equals(v2)){
                index2= i;
            }
        }
        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;
    }

    public void show(){
        for (int[] data:adjMat){
            System.out.println(Arrays.toString(data));
        }
    }

    //获取第n个节点的第一个邻接节点
    public int getFirstNeighbor(int n){
        for (int i = 0; i <vertex.length;i++){
            if (adjMat[n][i] == 1){
                return i;
            }
        }
        return -1;
    }

    //获取第n个节点的w之后的第二个邻接节点
    public int getNextNeighbor(int n, int w){
        for (int i = w+1; i<vertex.length;i++){
            if (adjMat[n][i] == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 对一个节点进行bfs(应该传入值还是下标）
     * 三个关键点：输出、标记、加入队列
     * @param n 该节点的下标
     */
    private void bfs(boolean[] isVisted,int n){
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(vertex[n] + "-->");
        isVisited[n] = true;
        queue.addLast(n);
        while (!queue.isEmpty()){
            int u = queue.removeFirst();
            int w = getFirstNeighbor(u);
            while (w != -1){
                if (isVisited[w] != true){
                    System.out.print(vertex[w] + "-->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);
            }
            //System.out.println(queue);
        }
    }
    //对整个图进行bfs，也就是逐个顶点的bfs
    public void bfs(){
        for (int i = 0; i < vertex.length; i++){
            bfs(isVisited,i);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        String[] vertex = new String[]{"A","B","C","D","E"};
        for (int i = 0; i<vertex.length; i++){
            g.addVertex(vertex[i]);
        }
        g.addEdges(vertex[0],vertex[2]);
        g.addEdges(vertex[1],vertex[2]);
        g.addEdges(vertex[0],vertex[1]);
        g.addEdges(vertex[1],vertex[3]);
        g.addEdges(vertex[1],vertex[4]);
        g.show();
        g.bfs();
    }
}
