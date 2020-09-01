package 基本数据结构的实现.树.RedBlackTree;

/**
 * 考虑一下为什么需要设置黑色，设置红色，判断是否是黑色，是否是红色这种的呢（难道只是为了代码简洁吗）
 * 为什么总是要一个public调用一个private，比如inOrderPrint
 * 红黑树中需要左旋右旋的节点一定是有孩子节点吗
 * 好好测试一下顺序会影响结果吗？r.left = p; p.parent = r;
 */
public class RBTree02 {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private RBNode root;

    public RBNode getRoot(RBNode root) {
        return root;
    }

    //获取节点的父节点（既然node类中已经有了getParent方法，这里是否有意义
    private RBNode parentOf(RBNode node){
        if (node != null){
            return node.parent;
        }
        return null;
    }

    /**
     * 以某个节点为支撑，进行左旋
     * 什么时候需要左旋考虑过吗，支撑节点一定不是叶子节点嘛
     * 左旋时支撑节点的右子节点一定不为空
     * @parm node
     */
    private void leftRotate(RBNode p){
        RBNode r,pp,rl;
        if (p != null && (r = p.left) != null){
            if ((rl = p.right = r.left) != null){
                rl.parent = p;
            }
            if ((pp = r.parent= p.parent) == null){
                this.root = r;
            }else if (pp.left == p){
                pp.left = r;
            }else{
                pp.right = r;
            }
            r.left = p;
            p.parent = r;
        }
    }

    private void rightRotate(RBNode p){
        RBNode l,pp,lr;
        if (p != null && (l = p.left) != null){
            if ((lr = p.left = l.right)!= null){
                lr.parent = p;
            }
            if ((pp= l.parent = p.parent) == null){
                this.root = l;
            }else if (pp.left == p){
                pp.left = l;
            }else{
                pp.right = l;
            }
            l.right = p;
            p.parent = l;
        }
    }

    //这里需要加一个判断，判断节点不是null
    private boolean isRed(RBNode node){
        if (node != null){
            return node.isColor() == RED;
        }
        return false;
    }

    private boolean isBlack(RBNode node){
        if (node != null){
            return node.isColor() == BLACK;
        }
        return false;
    }

    private void setRed(RBNode node){
        if (node != null){
            node.setColor(RED);
        }
    }

    private void setBlack(RBNode node){
        if (node != null){
            node.setColor(BLACK);
        }
    }

    public void inOrderPrint(){
        if (this.root != null){
            inOrderPrint(root);
        }
    }

    private void inOrderPrint(RBNode node){
        while (node != null){
            inOrderPrint(node.left);
            System.out.println(node);
            inOrderPrint(node.right);
        }
    }

    static class RBNode<K extends Comparable<K>,V>{
        private RBNode left;
        private RBNode right;
        private RBNode parent;
        private boolean color;
        private K key;
        private V value;

        public RBNode() {
        }

        @Override
        public String toString() {
            return "RBNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public RBNode(RBNode left, RBNode right, RBNode parent, boolean color, K key, V value) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
