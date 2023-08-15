package treeleftrightmirrorview;

import com.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLeftView {
    static void LeftView(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        //设置 size 和 child 两个标记，child在循环中会变，size不会变，作为循环条件
        //第一层只有根节点1个，所以size = 1
        int size = 1;
        //记录孩子数
        int child;
        while (!queue.isEmpty()) {
            //初始化孩子数为 0
            child = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node1 = queue.poll();
                // i = 0,说明是该层第一个结点
                //if i == size-1; right
                if (i == 0) {
                    System.out.println(node1.value);
                }
                if (node1.left != null) {
                    queue.offer(node1.left);
                    child++;
                }
                if (node1.right != null) {
                    queue.offer(node1.right);
                    child++;
                }
            }
            size = child;
        }
    }

//    镜像二叉树
//    void Mirror(TreeNode *pRoot) {
//        if((pRoot == NULL) || (pRoot->left == NULL && pRoot->right == NULL)){
//            return;
//        }
//
//        //交换根节点的左右结点
//        TreeNode *pTemp = pRoot->left;
//        pRoot->left = pRoot->right;
//        pRoot->right = pTemp;
//
//        //递归左子树
//        if(pRoot->left){
//            Mirror(pRoot->left);
//        }
//        //递归右子树
//        if(pRoot->right){
//            Mirror(pRoot->right);
//        }
//    }

}
