package treemaxwidth;

import com.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {

    private int maxW = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexList = new LinkedList<>();
        queue.add(root);
        indexList.add(1);
        int size = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            size--;
            int index = indexList.removeFirst();
            if (node.left != null) {
                queue.add(node.left);
                indexList.add(2 * index);
            }
            if (node.right != null) {
                queue.add(node.right);
                indexList.add(2 * index + 1);
            }
            if (size == 0) {
                if (indexList.size() >= 2) {
                    maxW = Math.max(maxW, indexList.getLast() - indexList.getFirst() + 1);
                }
                size = queue.size();
            }
        }

        return maxW;
    }

    public int widthOfBinaryTree1(TreeNode root) {
        // 避免异常的产生
        if(root==null){
            return 0;
        }
        // 创建一个队列来进行广度优先遍历,注意这个地方就不要使用Queue<TreeNode> queue=new LinkedList<TreeNode>();
        // 因为父类不能调用子类的方法：getLast getFirst
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        // 创建一个变量来保存最大宽度
        int maxwidth=0;
        // 将根节点入队列
        queue.offer(root);
        // 改变根结点的值
        root.value=0;
        while(!queue.isEmpty()){
            TreeNode k=new TreeNode(0);
            // 记录当前队列中的个数
            int cout=queue.size();
            //创建一个变量来计算每层的宽度
            int width=queue.getLast().value-queue.getFirst().value+1;
            for(int i=0;i<cout;i++){
                TreeNode temp=queue.poll();
                if(temp.left!=null){
                    queue.offer(temp.left);
                    temp.left.value=temp.value*2+1;
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                    temp.right.value=temp.value*2+2;
                }
            }
            // 求出每一层的宽度
            // 通过比较找除最大宽度
            if(width>maxwidth){
                maxwidth=width;
            }
        }
        return maxwidth;
    }
}
