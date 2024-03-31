package FindBinaryTreeComonAncestor;


import com.common.TreeNode;

//找到二叉树公共祖先
public class FindBinaryTreeCommonAncestor {

    /* 先序遍历各个关卡(因为要汇总给老大情况，即父节点要汇总情况) */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
         /* 总结左右子树的收获,对于每个关卡(每个节点)判断它两块领地是否有逃犯，其中一个有没事，
        你奉命押给上级即可(即p、q其中一个作为最近公共祖先)，两块领地各有一个，那你完了！！
        你自己就要切腹自尽，把你自己送上去(即当前root作为最近公共祖先)，  总共最近公共祖先
        也就这三种情况(1.p是q的最近公共祖先，2.q是p的最近公共祖先，3.离他俩最近的老大) */
        if(left!=null&&right!=null){
            return root;
        }else if(left!=null){
            return left;
        }else if(right!=null){
            return right;
        }else{
            return null;
        }
    }
}
