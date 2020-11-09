package convertlinklist;

import com.common.Node;

public class convertlinklist {

    public static Node reverse(Node head){
        if(head == null||head.next == null){
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static Node reverseList(Node node) {
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        Node t1 = new Node(0);
        Node t2 = new Node(1);
        t1.next = t2;
        Node t3 = new Node(2);
        t2.next = t3;
        Node t4 = new Node(3);
        t3.next = t4;
        Node t5 = new Node(4);
        t4.next = t5;
        t1 = reverse(t1);
        for(;t1!=null;){
            System.out.println(t1.value);
            t1 = t1.next;
        }
    }
}
