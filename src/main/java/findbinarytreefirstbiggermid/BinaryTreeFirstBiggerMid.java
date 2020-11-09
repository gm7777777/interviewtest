package findbinarytreefirstbiggermid;

import com.common.TreeNode;

public class BinaryTreeFirstBiggerMid {

    public static TreeNode getMinNode(TreeNode node){
        if(node == null){
            return node;
        }
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }

    public static TreeNode getMaxNode(TreeNode node){
        if(node == null){
            return node;
        }
        while(node.right!=null){
            node = node.right;
        }
        return node;
    }

    public static TreeNode getNode(TreeNode root){
        TreeNode min = getMinNode(root);
        TreeNode max = getMaxNode(root);

        int mid = (min.value+max.value)/2;
        TreeNode cur = null;
        while(root!=null){
            if(root.value>mid){
                root = root.right;
            }else{
                cur = root;
                root = root.left;
            }
        }
        return cur;
    }
}
