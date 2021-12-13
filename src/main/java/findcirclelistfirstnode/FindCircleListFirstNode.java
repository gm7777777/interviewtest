package findcirclelistfirstnode;
//给定单链表(head)，如果有环的话请返回从头结点进入环的第一个节点。
public class FindCircleListFirstNode {

    public static ListNode detectCycle(ListNode head) {
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

    static class ListNode{

        int val;
        ListNode next ;
        public ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode t0 = new ListNode(0);
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        ListNode t5 = new ListNode(5);
        ListNode t6 = new ListNode(6);
        ListNode t7 = new ListNode(7);
        ListNode t8 = new ListNode(8);
        ListNode t9 = new ListNode(9);
        t0.next=t1;
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
        t5.next=t6;
        t6.next=t7;
        t7.next=t8;
        t8.next=t9;
        t9.next=t6;
        detectCycle(t0);
    }
}
