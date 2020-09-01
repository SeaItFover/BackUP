package leetcode.算法思想.排序;

import java.util.*;

public class lll {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S==T){
            return 0;
        }

        Map<Integer,Set<Integer>> map=new HashMap<Integer, Set<Integer>>();
        for(int i=0;i<routes.length;++i){
            for(int j:routes[i]){
                if(!map.containsKey(j)){
                    map.put(j,new HashSet<Integer>());
                }
                map.get(j).add(i);
            }
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        Set<Integer> vis=new HashSet<Integer>();
        for(int st:map.get(S)){
            queue.offer(st);
            vis.add(st);
        }
        int ans=1;
        while (!queue.isEmpty()){
            Queue<Integer> t=new LinkedList<Integer>(); //备用节点存新添加的未访问过的节点
            while (!queue.isEmpty()){
                int curCar=queue.poll();
                for(int k:routes[curCar]){ //遍历当前公交车节点所连接的所有公交车站节点
                    if(k==T){ //遇到则直接返回结果
                        return ans;
                    }
                    for(int nextCar:map.get(k)){ //遍历当前公交车站节点连接的所有公交车节点
                        if(!vis.contains(nextCar)){ //未访问过的加入备用队列中
                            t.offer(nextCar);
                            vis.add(nextCar);
                        }
                    }
                }
            }
            ++ans;
            queue=t;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] r={{1, 2, 7}, {3, 6, 7}};
        System.out.println(new lll().numBusesToDestination(r,1,6));
    }
}
//import java.awt.Point;
//rile
//class Solution {
//    public int numBusesToDestination(int[][] routes, int S, int T) {
//        if (S==T) return 0;
//        int N = routes.length; //几条路线
//        LinkedList
//                Queue
//
//        List<List<Integer>> graph = new ArrayList();
//        for (int i = 0; i < N; ++i) {
//            Arrays.sort(routes[i]);
//            graph.add(new ArrayList());
//        }
//        Set<Integer> seen = new HashSet();
//        Set<Integer> targets = new HashSet();
//        Queue<Point> queue = new ArrayDeque();
//
//        // Build the graph.  Two buses are connected if
//        // they share at least one bus stop.
//
//        for (int i = 0; i < N; ++i)
//            for (int j = i+1; j < N; ++j)
//                if (intersect(routes[i], routes[j])) {
//                    graph.get(i).add(j);
//                    graph.get(j).add(i);
//                }
//
//        // Initialize seen, queue, targets.
//        // seen represents whether a node has ever been enqueued to queue.
//        // queue handles our breadth first search.
//        // targets is the set of goal states we have.
//        for (int i = 0; i < N; ++i) {
//            if (Arrays.binarySearch(routes[i], S) >= 0) {
//                seen.add(i);
//                queue.offer(new Point(i, 0));
//            }
//            if (Arrays.binarySearch(routes[i], T) >= 0)
//                targets.add(i);
//        }
//
//        while (!queue.isEmpty()) {
//            Point info = queue.poll();
//            int node = info.x, depth = info.y;
//            if (targets.contains(node)) return depth+1;
//            for (Integer nei: graph.get(node)) {
//                if (!seen.contains(nei)) {
//                    seen.add(nei);
//                    queue.offer(new Point(nei, depth+1));
//                }
//            }
//        }
//
//        return -1;
//    }
//
//    public boolean intersect(int[] A, int[] B) {
//        int i = 0, j = 0;
//        while (i < A.length && j < B.length) {
//            if (A[i] == B[j]) return true;
//            if (A[i] < B[j]) i++; else j++;
//        }
//        return false;
//    }
//}

