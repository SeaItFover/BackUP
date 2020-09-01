package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.

 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    private int mCount = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            dfs(node, sum, 0);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return mCount;
    }

    private void dfs(TreeNode node, int sum, int currentSum) {
        if (node == null) {
            return;
        }
        currentSum = currentSum + node.val;
        if (sum == currentSum) {
            mCount++;
        }

        dfs(node.left, sum, currentSum);
        dfs(node.right, sum, currentSum);
    }
}
