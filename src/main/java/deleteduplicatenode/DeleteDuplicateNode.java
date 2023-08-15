package deleteduplicatenode;

import com.common.Node;

//去除重复节点
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
