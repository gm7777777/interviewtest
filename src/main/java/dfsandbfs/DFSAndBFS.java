package dfsandbfs;

import com.common.TreeNode;

import java.util.*;

public class DFSAndBFS {

    //广度优先遍历是使用队列实现的
    public void BroadFirstSearch(TreeNode nodeHead) {
        if(nodeHead==null) {
            return;
        }
        Queue<TreeNode> myQueue=new LinkedList<>();
        myQueue.add(nodeHead);
        while(!myQueue.isEmpty()) {
            TreeNode node=myQueue.poll();
            System.out.print(node.value+" ");
            if(null!=node.left) {
                myQueue.add(node.left);    //深度优先遍历，我们在这里采用每一行从左到右遍历
            }
            if(null!=node.right) {
                myQueue.add(node.right);
            }

        }
    }

    //深度优先遍历
    public void depthFirstSearch(TreeNode nodeHead) {
        if(nodeHead==null) {
            return;
        }
        Stack<TreeNode> myStack=new Stack<>();
        myStack.add(nodeHead);
        while(!myStack.isEmpty()) {
            TreeNode node=myStack.pop();    //弹出栈顶元素
            System.out.print(node.value+" ");
            if(node.right!=null) {
                myStack.push(node.right);    //深度优先遍历，先遍历左边，后遍历右边,栈先进后出
            }
            if(node.left!=null) {
                myStack.push(node.left);
            }
        }

    }


    //中序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        // 迭代法：用栈来做
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        // 入栈前要保证root不为空
        if (root == null){
            return list;
        }
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            list.add(temp.value); // 中
            // 注意代码中空节点不入栈
            if (temp.right != null) {
                st.push(temp.right); // 右
            }
            // 注意代码中空节点不入栈
            if (temp.left != null) {
                st.push(temp.left); // 左
            }
        }
        return list;
    }


    //二叉树层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size;
        TreeNode tmp;
        while(!q.isEmpty()) {
            size = q.size();
            List<Integer> list = new ArrayList<>(size);
            while(size > 0) {
                tmp = q.poll();
                list.add(tmp.value);
                if(tmp.left != null) {
                    q.offer(tmp.left);
                }
                if(tmp.right != null) {
                    q.offer(tmp.right);
                }
                size--;
            }
            ans.add(list);
        }
        return ans;
    }

}
