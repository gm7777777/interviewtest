package serializetree;

import com.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder(); // 保存最终的结果
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return res.toString();
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                res.append(cur.value + " ");
                queue.offer(cur.left); //左节点入队列
                queue.offer(cur.right); //右节点入队列
            } else {
                res.append("# ");
            }
        }
        System.out.println(res.toString().trim());
        return res.toString().trim();

    }


    public TreeNode deserialize(String data) {
        if (data.length() == 0){
            return null;
        }
        String[] str = data.split(" ");
        TreeNode root = createTree(str);
        return root;
    }
    //按层BFS的反序列化核心代码
    //根据层遍历的反序列化是重做层遍历，遇到"#"就生成null节点，同时不把null节点放到队列里即可
    public TreeNode createTree(String[] str) {
        TreeNode root = null;
        int index = 0;
        root = createTreeNode(str[index++]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = createTreeNode(str[index++]);
            node.right = createTreeNode(str[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public TreeNode createTreeNode(String str) {
        if (str.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(str));
    }

}