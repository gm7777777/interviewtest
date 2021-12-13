package twonodebinarytreecommonparent;

import com.common.TreeNode;

public class TwonodeBinaryTreeeCommonParent {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,TreeNode q){
        //若节点 p在节点 root 的左（右）子树中，或 p=root ，则称 root是 p的祖先
        if(root==null||root==p||root==q)return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null&&right==null) return null;
        if(left==null)return right;
        if(right==null) return left;
        return root;
    }
}
