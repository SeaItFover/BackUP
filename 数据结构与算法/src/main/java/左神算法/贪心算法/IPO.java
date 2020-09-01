package 左神算法.贪心算法;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最多能做的项目
 */
public class IPO {

    public static class Node{
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[]  Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCost = new PriorityQueue<>(Comparator.comparingInt(n -> n.c));
        PriorityQueue<Node> maxProfit = new PriorityQueue<>((n1, n2) -> n2.p - n1.p);
        for (int i = 0; i < nodes.length; i++) {
            minCost.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && minCost.peek().c <= W) {
                maxProfit.add(minCost.poll());
            }
            if (maxProfit.isEmpty()) {
                return W;
            }
            W += maxProfit.poll().p;
        }
        return W;
    }
}
