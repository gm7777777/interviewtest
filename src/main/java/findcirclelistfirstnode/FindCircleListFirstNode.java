package findcirclelistfirstnode;
//给定单链表(head)，如果有环的话请返回从头结点进入环的第一个节点。
public class FindCircleListFirstNode {

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {return null;}
        ListNode f = head;
        ListNode s = head;
        //判断是否有环
        while(f != null && f.next!=null){
            f = f.next.next;
            s = s.next;
            if(f == s){
                break;
            }

        }
        //没有环，直接返回
        if(f!=s) {return null;}
        //让快指针指向头结点，
        f = head;
        //下次快慢结点相等时就是环入口
        while(f!=s){
            f = f.next;
            s = s.next;
        }
        return f;
    }

    class ListNode{
        int val;
        ListNode next ;
    }
}
