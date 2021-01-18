package ms;

import com.common.TreeNode;

public class binarytreeconverlinklist {

    //双向链表头结点
    private static TreeNode pHead = null;
    //双向链表尾结点
    private static TreeNode pEnd = null;

    /**
     * 方法功能：把二叉树转换为双向链表
     * @param root 二叉树的根节点
     */
    public static void inOrderBSTree(TreeNode root){
        if(root == null){
            return;
        }
        //转换root的左子树
        inOrderBSTree(root.left);
        //使当前结点的左孩子指向双向链表中最后一个结点
        root.left = pEnd;
        //双向链表为空，当前遍历的结点为双向链表的头结点
        if(pEnd == null){
            pHead = root;
        }
        //使双向链表中最后一个结点的右孩子指向当前结点
        else {
            pEnd.right = root;
        }
        //将当前结点设为双向链表中最后一个结点
        pEnd = root;
        //转换root的右子树
        inOrderBSTree(root.right);
    }
}
