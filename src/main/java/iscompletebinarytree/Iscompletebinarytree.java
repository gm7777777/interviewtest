package iscompletebinarytree;

public class Iscompletebinarytree {

//    判断一棵树是否是完全二叉树的思路
//1>如果树为空，则直接返回错
//2>如果树不为空：层序遍历二叉树
//2.1>如果一个结点左右孩子都不为空，则pop该节点，将其左右孩子入队列；
//            2.1>如果遇到一个结点，左孩子为空，右孩子不为空，则该树一定不是完全二叉树；
//            2.2>如果遇到一个结点，左孩子不为空，右孩子为空；或者左右孩子都为空；则该节点之后的队列中的结点都为叶子节点；该树才是完全二叉树，否则就不是完全二叉树；


//    bool check(BiTree T)
//    {
//        if (T == NULL)
//            return false;
//        queue<BiTree> Q;
//        Q.push(T);
//        while (!Q.empty())
//        {
//            BiTree p = Q.front();
//            Q.pop();
//            if (p->left && p->right) {
//                Q.push(p->left);
//                Q.push(p->right);
//            }
//            else if(p->right && p-left == NULL)
//                return false;
//            else
//            {
//                if(p->left && p-right == NULL)
//                    Q.push(p->left);
//                while(!Q.empty())
//                {
//                    p = Q.front(); Q.pop();
//                    if(p->left || p->right)
//                        return false;
//                }
//
//            }
//        }
//        return true;
//    }
}
