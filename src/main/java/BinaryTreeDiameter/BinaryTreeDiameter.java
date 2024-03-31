package BinaryTreeDiameter;

import com.common.TreeNode;


//求二叉树的直径
//示例 1：
//                        1
//                       /\
//                       2 3
//                      /\
//                      4 5
//        输入：root = [1,2,3,4,5]
//        输出：3
//        解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
//        示例 2：
//
//        输入：root = [1,2]
//        输出：1
public class BinaryTreeDiameter {


    int getHigh (TreeNode root) {
        if (root==null) return 0;
        return 1 + Math.max(getHigh(root.left),getHigh(root.right));
    }
    int diameterOfBinaryTree(TreeNode root) {
        if (root==null) return 0;
        int rM = getHigh(root.left) + getHigh(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(rM,Math.max(left,right));
    }
}
