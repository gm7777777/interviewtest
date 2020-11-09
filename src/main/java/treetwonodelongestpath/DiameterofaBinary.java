package treetwonodelongestpath;

import com.common.TreeNode;

class Res{
    int max;
}
public class DiameterofaBinary {


    /**
     * 求解一颗二叉树中两个叶子节点最长的路径
     * @param root
     *
     */
    public static int getDiameter(TreeNode root, Res rs){
        if(root==null){
            return 0;
        }
        int left = getDiameter(root.left, rs);
        int right = getDiameter(root.right, rs);
        int sum = left+right+1;
        if(sum>rs.max){
            rs.max = sum;
        }
        return (right>left?right:left)+1;//返回高度
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(4);
        root.left.left.right.left.left = new TreeNode(4);
        root.left.left.right.left.right = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(4);
        root.left.right.right.left = new TreeNode(4);
        root.left.right.right.right = new TreeNode(4);
        root.left.right.right.right.right = new TreeNode(4);
        Res rs = new Res();
        rs.max = Integer.MIN_VALUE;
        getDiameter(root, rs);
        System.out.println(rs.max);

    }

}
