package treeleftrightrotated;

import com.common.Node;
import com.common.TreeNode;

public class TreeLeftRightRotated {

    public TreeNode node = null;

    public void rotateNode(TreeNode node){
        this.node = node;
    }
    //左旋转
    public void leftRotate(){
        //创建一个新的节点，且其值等于二叉树根节点的值
        TreeNode newNode = new TreeNode(this.node.getValue());
        //把新节点的左子树设置成当前节点的左子树
        newNode.setLeft(this.node.getLeft());
        //把新节点的右子树设置成当前节点右子树的左子树
        newNode.setRight(this.node.getRight().getLeft());
        //把当前节点的值设置成其右子节点的值
        this.node.setValue(this.node.getRight().getValue());
        //把当前节点的右子树设置成其右子树的右子树
        this.node.setRight(this.node.getRight().getRight());
        //把当前节点的左子树设置成新节点
        this.node.setLeft(newNode);
    }


    //右旋转
    public void rightRotate(){
        //创建一个新的节点，且其值等于二叉树根节点的值
        TreeNode newNode = new TreeNode(this.node.getValue());
        //把新节点的右子树设置成当前节点的右子树
        newNode.setRight(this.node.getRight());
        //把新节点的左子树设置成当前节点左子树的右子树
        newNode.setLeft(this.node.getLeft().getRight());
        //把当前节点的值设置成其左子节点的值
        this.node.setValue(this.node.getLeft().getValue());
        //把当前节点的左子树设置成其左子树的左子树
        this.node.setLeft(this.node.getLeft().getLeft());
        //把当前节点的右子树设置成新节点
        this.node.setRight(newNode);
    }

}
