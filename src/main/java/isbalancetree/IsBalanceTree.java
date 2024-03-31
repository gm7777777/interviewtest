package isbalancetree;

import com.common.TreeNode;


//平衡二叉树 高度相差1
public class IsBalanceTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            //左子树的最大高度和右子数的最大高度差的绝对值小于等于1，并且左右子树都是平衡二叉树
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
