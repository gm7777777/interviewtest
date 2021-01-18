package ms.findcloestfather;

import com.common.TreeNode;
//设计一个算法，找出二叉树上任意两个结点的最近共同父结点。

//后序遍历
public class FindClosestFather {

    public static TreeNode findParentNode(TreeNode root, TreeNode node1, TreeNode node2){
        if(root == null || root == node1 || root == node2){
            return root;
        }
        TreeNode lchild = findParentNode(root.left, node1, node2);
        TreeNode rchild = findParentNode(root.right, node1, node2);
        //root的左子树中没有结点node1和node2，那么一定在root的右子树上
        if(null == lchild){
            return rchild;
        }
        //root的右子树中没有结点node1和node2，那么一定在root的左子树上
        else if(null == rchild){
            return lchild;
        }
        //node1、node2分别在root的左右子树上时，root就是他们的最近公共父节点
        else {
            return root;
        }
    }




//    public static BITNode arrayToTree(int[] arr,int start,int end){
//        BITNode root = null;
//        if(end >= start){
//            root = new BITNode();
//            int mid = (start + end + 1)/2;
//            //二叉树根节点为数组中间的元素
//            root.data = arr[mid];
//            //递归方法用左半部分数组构造root的左子树
//            root.lchild = arrayToTree(arr,start,mid-1);
//            //递归方法用右半部分数组构造root的右子树
//            root.rchild = arrayToTree(arr,mid+1,end);
//        }else{
//            root = null;
//        }
//        return root;
//    }
//
//
//    /**
//     * 方法一：路径对比法
//     * 获取二叉树从根节点root到node结点的路径
//     * @param root 根结点
//     * @param node 二叉树中某个结点
//     * @param s 用来存储路径的栈
//     * @return node在root的子树上，或node==root时返回true，否则返回false
//     */
//    private static boolean getPathFromRoot(BITNode root, BITNode node, Stack<BITNode> s){
//        if(root == null){
//            return false;
//        }
//        if(root == node){
//            s.push(root);
//            return true;
//        }
//        if(getPathFromRoot(root.lchild,node,s) || getPathFromRoot(root.rchild,node,s)){
//            s.push(root);
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 查找二叉树中两个结点最近的共同父节点
//     * @param root
//     * @param node1
//     * @param node2
//     * @return
//     */
//    public static BITNode findParentTreeNode(BITNode root,BITNode node1,BITNode node2){
//        //保存从root到node1的路径
//        Stack<BITNode> s1 = new Stack<>();
//        //保存从root到node2的路径
//        Stack<BITNode> s2 = new Stack<>();
//        getPathFromRoot(root,node1,s1);
//        getPathFromRoot(root,node2,s2);
//        BITNode commomParent = null;
//        //获取最靠近node1和node2的父节点
//        while(s1.peek() == s2.peek()){
//            commomParent = s1.peek();
//            s1.pop();
//            s2.pop();
//        }
//        return commomParent;
//    }
}
