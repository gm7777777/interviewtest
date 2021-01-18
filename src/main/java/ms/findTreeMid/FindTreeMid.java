package ms.findTreeMid;


//一棵排序二叉树，令 f=(最大值+最小值)/2，设计一个算法，找出距离f值最近、大于f值的结点
public class FindTreeMid {

//
//    BinaryNode* findf(BinaryNode* root)
//    {
//        if(!root)
//            return NULL;
//        int maxVal = 0;
//        int minVal = 0;
//        //最大值
//        BinaryNode* pNode = root;
//        while(pNode->m_right)
//        {
//            pNode = pNode->m_right;
//        }
//        maxVal = pNode->m_data;
//        //最小值
//        pNode = root;
//        while(pNode->m_left)
//            pNode = pNode->m_left;
//        minVal = pNode->m_data;
//
//        if(minVal == maxVal)
//            return NULL;
//        int f = (maxVal + minVal) / 2;
//
//        pNode = root;
//        //不变式，查询节点一定在pNode子树上
//        //while(pNode->m_left || pNode->m_right)
//        while(1)
//        {
//            if(pNode->m_data <= f)
//                pNode = pNode->m_right;
//            if(pNode->m_data > f)
//            {
//                if(pNode->m_left && pNode->m_left->m_data > f)
//                    pNode = pNode->m_left;
//                else
//                    return pNode;
//            }
//        }
////	return pNode;

    }
