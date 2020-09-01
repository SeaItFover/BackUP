package 基本数据结构的实现.树.binarttree;

public class BinaryTree {
    /**
     * 二叉树类中只有一个字段就是root树结点
     * @author sp
     */
    TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void frontShow(){
        root.frontShow();
    }

    public void middleShow(){
        root.middleShow();
    }

    public void rearShow(){
        root.rearShow();
    }

    public boolean frontFind(int value){
        return root.frontFind(value);
    }

}
