package treefindKth;

import com.common.TreeNode;

//找到二叉树中第k个元素
//中序便利查找
public class TreeFindKth {

    int cnt = 0, ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    public void inOrder(TreeNode root, int k) {
        if (root==null) return;
        inOrder(root.left, k);
        cnt++;
        if (cnt==k) {
            ans = root.value;
            return;
        }
        inOrder(root.right, k);
    }
}
