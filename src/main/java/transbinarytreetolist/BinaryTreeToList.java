package transbinarytreetolist;

import com.common.Node;
import com.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeToList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        Node n = new Node(root.value);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            n.next = new Node(node.value);
            if(node.left!=null){
                q.offer(node.left);
            }
            if(node.right!=null){
                q.offer(node.right);
            }
            n = n.next;
        }

    }

    public void flatten(TreeNode root) {
        while(root!=null)
        {
            if(root.left==null) {
                root = root.right;
            }
            else
            {
                TreeNode pre=root.left;
                while(pre.right!=null) {
                    pre = pre.right;
                }
                pre.right=root.right;
                root.right=root.left;
                root.left=null;
                root=root.right;
            }
        }
    }

    public void flatten1(TreeNode root) {

        if(root==null) {
            return;
        }
        TreeNode pre=null;
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.push(root);

        while(!st.isEmpty())
        {
            TreeNode temp=st.pop();
            if(pre!=null)
            {
                pre.right=temp;
                pre.left=null;
            }
            if(temp.right!=null) {
                st.push(temp.right);
            }
            if(temp.left!=null) {
                st.push(temp.left);
            }
            pre=temp;
        }
    }



}
