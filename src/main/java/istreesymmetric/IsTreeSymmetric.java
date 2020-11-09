package istreesymmetric;

import com.common.TreeNode;

//是否对称二叉树
public class IsTreeSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        }
        return issymmetric(root.left,root.right);
    }

    public boolean issymmetric(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;}
        if(root1==null||root2==null){
            return false;}
        if(root1.value!=root2.value){
            return false;}
        return issymmetric(root1.left,root2.right)&&issymmetric(root1.right,root2.left);
    }

}
