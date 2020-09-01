package 基本数据结构的实现.树.binarttree;

/**
 * 老师构造树方法的缺点：
 * 如果树的深度超过3，就会很麻烦（主要是给结点赋值左右结点很麻烦）
 */
public class TestBinaryTree {

    public static void main(String[] args) {

        BinaryTree binTree = new BinaryTree();

        TreeNode root = new TreeNode(1);
        binTree.setRoot(root);

        TreeNode lNode = new TreeNode(2);
        root.setLeftNode(lNode);

        TreeNode rNode = new TreeNode(3);
        root.setRightNode(rNode);

        lNode.setLeftNode(new TreeNode(4));
        lNode.setRightNode(new TreeNode(5));
        rNode.setLeftNode(new TreeNode(6));
        rNode.setRightNode(new TreeNode(7));

        //三种遍历的方式
        binTree.frontShow();
        System.out.println("---------");
        binTree.middleShow();
        System.out.println("---------");
        binTree.rearShow();

        System.out.println(binTree.frontFind(7));

    }

}
