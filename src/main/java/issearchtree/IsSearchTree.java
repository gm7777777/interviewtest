package issearchtree;

public class IsSearchTree {


//    bool IsSearchTree(const BinaryTreeNode* pRoot, int min, int max)
//    {
//        if (pRoot == nullptr)
//            return true;
//
//        if (pRoot->m_nValue < min || pRoot->m_nValue >= max)
//            return false;
//
//        // 进入左子树时，更新max；进入右子树时，更新min
//        // 如果任一节点不能通过检查，则停止并返回false
//        if (!IsSearchTree(pRoot->m_pLeft, min, pRoot->m_nValue) || !IsSearchTree(pRoot
//                ->m_pRight, pRoot->m_nValue, max))
//            return false;
//
//        return true;
//    }
}
