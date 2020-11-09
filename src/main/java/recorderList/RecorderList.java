package recorderList;

import com.common.Node;

//比如：$ L: L_0→L_1→…→L{n-1}→L_n​$，首先利用快慢指针将该链表分为两个部分：
//
//        La:L0→L1→…Ln2L_a:L_0→L_1→…L_{\frac{n}{2}}L
//        a:L 0→L 1→…L 2 n,
//        Lb:Ln21→Ln22→…LnL_b:L_{\frac{n}{2} 1}→L_{\frac{n}{2} 2}→…L_{n}L
//        b:L 2n 1→L 2n 2→…L n
//        ​然后将LbL_bL b
//        ​翻转，然后合并LaL_aL a
//        ​和LbL_bL b
//        ​即可。

public class RecorderList {

    public void reorderList(Node head) {
        if (head != null && head.next != null) {
            Node fast, slow;
            fast = slow = head;
            //快慢指针找出链表的中间节点
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            //拆分链表
            Node preNode = slow.next;
            slow.next = null;
            Node afterNode = preNode.next;
            preNode.next=null;
            //翻转后一半链表
            while (afterNode != null) {
                Node tempNode = afterNode.next;
                afterNode.next = preNode;
                preNode = afterNode;
                afterNode = tempNode;
            }

            //合并链表
            while (preNode != null && head != null) {
                Node tempNode1 = head.next;
                Node tempNode2 = preNode.next;
                head.next = preNode;
                preNode.next = tempNode1;
                preNode = tempNode2;
                head = tempNode1;

            }
        }

    }

}
