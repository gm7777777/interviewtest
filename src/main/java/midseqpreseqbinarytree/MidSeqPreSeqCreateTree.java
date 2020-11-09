package midseqpreseqbinarytree;


import com.common.TreeNode;

// 问题1： 根据二叉树中序和前序遍历结果重构二叉树
// 中序： 3 5 6 4 7 9 2  left-mid-right
// 前序： 4 5 3 6 2 7 9   mid - left - right
public class MidSeqPreSeqCreateTree {

    public static void main(String[] args) {
        MidSeqPreSeqCreateTree tree = new MidSeqPreSeqCreateTree();
        TreeNode root = new TreeNode(-1);
        tree.createTreeByMidSeqAndPreSeq("3564792","4536279",root);
        System.out.println(root);
    }

    public void createTreeByMidSeqAndPreSeq(String midSeq , String preSeq, TreeNode treeNode){
        char curNode = preSeq.charAt(0);
        treeNode.value = Integer.valueOf(String.valueOf(curNode));
        if(preSeq.length()<1){
            return ;
        }
        String midLeftSeq = midSeq.substring(0,midSeq.indexOf(String.valueOf(curNode)));
        String midRightSeq = midSeq.substring(midSeq.indexOf(String.valueOf(curNode))+1,preSeq.length());

        if(midSeq.length()<1){
            return ;
        }
        String preLeftSeq = preSeq.substring(1,midLeftSeq.length()+1);
        String preRightSeq = preSeq.substring(midLeftSeq.length()+1,midSeq.length());

        if(preLeftSeq.length()>0||midLeftSeq.length()>0){
            TreeNode left = new TreeNode(-1);
            treeNode.left = left;
            createTreeByMidSeqAndPreSeq(midLeftSeq,preLeftSeq,left);
        }
        if(preRightSeq.length()>0||midRightSeq.length()>0){
            TreeNode right = new TreeNode(-1);
            treeNode.right = right;
            createTreeByMidSeqAndPreSeq(midRightSeq,preRightSeq,right);
        }

    }
}
