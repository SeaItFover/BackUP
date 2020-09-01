package 每日练习.八月三十;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMP {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left =treeNode6;
        String s = serializableTreeByPre(treeNode1);
        System.out.println(s);
        System.out.println(Arrays.toString(s.split("_")));
        List<Integer> list = new ArrayList<>();
         
        System.out.println(getIndexOf("sdfads", "sd"));
        System.out.println(add("abda"));
    }

    //利用KMP获取子串在母串中的位置
    public static int getIndexOf(String str, String son) {
        if (str == null || son == null || str.length() < son.length()) {
            return -1;
        }
        int[] next = getNext(son);
        int i1 = 0;
        int i2 = 0;
        while (i1 < str.length() && i2 < son.length()) {
            if (str.charAt(i1) == son.charAt(i2)) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == son.length() ? i1 - i2 : -1;
    }

    public static int[] getNext(String str) {
        if (str.length() == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length()];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while (i < str.length()) {
            //i位置只能比i -1 位置大于1
            if (str.charAt(i - 1) == str.charAt(cn)) {
                next[i++] = ++cn;
            } else if (next[cn] == -1) {
                next[i++] = 0;
            } else {
                cn = next[cn];
            }
        }
        return next;
    }

    //往字符串后面最少添加几个字符，使得包含两个原字符串
    public static String add(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() == 1) {
            return str.concat(str);
        }
        int[] next = getNextAdd(str);
        return str.concat(str.substring(next[str.length()]));
    }

    private static int[] getNextAdd(String str) {
        int[] next = new int[str.length() + 1];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while (i <= str.length()) {
            if (str.charAt(i - 1) == str.charAt(cn)) {
                next[i++] = ++cn;
            } else if (next[cn] == -1) {
                next[i++] = 0;
            } else {
                cn = next[cn];
            }
        }
        return next;
    }

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static String serializableTreeByPre(TreeNode tree) {
        if (tree == null) {
            return "#_";
        }
        String str = tree.val + "_";
//        str += tree.val + "_";
        str = str.concat(serializableTreeByPre(tree.left));
        str = str.concat(serializableTreeByPre(tree.right));
        return str;
    }


}
