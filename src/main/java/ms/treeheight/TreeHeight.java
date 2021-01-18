package ms.treeheight;

import com.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeHeight {

    public class Solution2 {
        /**
         * 递归求解
         * 返回树的高度
         *
         * @param root TreeNode类 树根节点
         * @return int整型
         */
        public int getTreeHeight1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = getTreeHeight1(root.left);
            int right = getTreeHeight1(root.right);
            return left > right ? left + 1 : right + 1;
        }

        /***
         * 非递归求解
         * @param root
         * @return
         */
        public int getTerrHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //使用count进行层级统计。
            //nextCount保存的是每层遍历后新增到队列中的元素数量。
            //如果count++ = nextCount 就说明将该层遍历完了 deep++ nextCount等于队列中保存的下一层的所有结点数目。
            //以此类推
            int deep = 0, count = 0, nextCount = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                count++;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                if (count == nextCount) {
                    nextCount = queue.size();
                    count = 0;
                    deep++;
                }
            }
            return deep;
        }
    }
}
