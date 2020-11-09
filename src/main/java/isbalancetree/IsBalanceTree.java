package isbalancetree;

import com.common.TreeNode;


//平衡二叉树 高度相差1
public class IsBalanceTree {

    public static boolean isBalanceTree(TreeNode root){
        if(root == null){
            return true;
        }
        if(Math.abs(getHeight(root.right)-getHeight(root.left))>1){
            return false;
        }else{
            return true;
        }
    }

    public static int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(getHeight(node.right),getHeight(node.left))+1;
    }
}
