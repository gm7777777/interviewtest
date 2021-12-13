package deleteduplicatenode;

import com.common.Node;


//链表去重
public class DeleteDuplicateNode {

    public Node deleteDuplicates(Node head) {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.value == current.value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
