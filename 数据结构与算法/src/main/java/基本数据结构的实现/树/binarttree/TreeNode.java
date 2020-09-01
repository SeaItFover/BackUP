package 基本数据结构的实现.树.binarttree;

public class TreeNode {
    int value;
    TreeNode leftNode;
    TreeNode rightNode;

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public void frontShow(){
        System.out.println(value);
        if (leftNode != null){
            leftNode.frontShow();
        }
        if (rightNode != null){
            rightNode.frontShow();
        }
    }

    public void middleShow(){

        if (leftNode != null){
            leftNode.middleShow();
        }
        System.out.println(value);
        if (rightNode != null){
            rightNode.middleShow();
        }
    }

    public void rearShow(){

        if (leftNode != null){
            leftNode.rearShow();
        }
        if (rightNode != null){
            rightNode.rearShow();
        }
        System.out.println(value);
    }

    public boolean frontFind(int value){
        if (this.value == value){
            return true;
        }
        if (this.leftNode != null){
            if (this.leftNode.value == value){
                return true;
            }
            leftNode.frontFind(value);
        }
        if (this.rightNode != null){
            if (this.rightNode.value == value){
                return true;
            }
            rightNode.frontFind(value);
        }

        return false;
    }
}
