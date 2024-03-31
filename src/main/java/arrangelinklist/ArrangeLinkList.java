package arrangelinklist;

import com.common.Node;
import findtwolistcommnode.FindTwoListCommNode;

import java.util.Stack;
//输入：head = [1,2,3,4]
//        输出：[1,4,2,3]
//        示例 2：
//
//
//
//        输入：head = [1,2,3,4,5]
//        输出：[1,5,2,4,3]
public class ArrangeLinkList {

//    void reorderList(FindTwoListCommNode.ListNode* head) {
//        stack<FindTwoListCommNode.ListNode*> stk;
//        ListNode* t = head;
//        while (t->next) {
//            stk.push(t);
//            t = t->next;
//        }
//        while (t != head && head -> next != t) {
//            t->next = head->next;
//            head->next = t;
//            head  = t->next;
//            t = stk.top(); stk.pop();
//        }
//        t->next = nullptr;
//    }

    void reorderList1(Node head){
        Stack stk = new Stack();
        Node t = head;
        while(t.next!=null){
            stk.push(t);
            t = t.next;
        }
        while(t!=head&&head.next!=t){
            t.next = head.next;
            head.next = t;
            head = t.next;
            t = (Node) stk.peek();
            stk.pop();
        }
        t.next = null;
    }
}
