package mergesort;

public class MergeSort {


//    /**
//     * @Author Nxy
//     * @Date 2019/12/4
//     * @Param
//     * @Return
//     * @Exception
//     * @Description 数组并归排序
//     *  将begin、end间的数组分解为两个子序列并回归排序
//     */
//    public static void mergeSort(int[] nums, int begin, int end) {
//        int length = nums.length;
//        //回归条件，子序列长度为一时返回
//        if (begin == end) {
//            return;
//        }
//        //序列中点
//        int mid = (begin + end) / 2;
//        //排序左边子序列
//        mergeSort(nums, begin, mid);
//        //排序右边子序列
//        mergeSort(nums, mid + 1, end);
//        //并归已排序的左右子序列
//        merge(nums, begin, mid, end);
//
//    }
//
//    /**
//     * @Author Nxy
//     * @Date 2019/12/4
//     * @Param
//     * @Return
//     * @Exception
//     * @Description 并归  begin--mid  与  mid+1--end  两个子序列
//     */
//    public static void merge(int[] nums, int begin, int mid, int end) {
//        //临时数组大小
//        int length = end - begin + 1;
//        int[] temp = new int[length];
//        //临时数组将要填充的位置指针
//        int i = 0;
//        //左子序列将要拿出的位置指针
//        int left = begin;
//        //右子序列将要拿出的位置指针
//        int right = mid + 1;
//        while (i < length) {
//            //一个子序列为空，将另一个子序列余下的元素放入临时数组
//            if (left == mid + 1) {
//                System.arraycopy(nums, right, temp, i, end - right + 1);
//                break;
//            }
//            if (right == end + 1) {
//                System.arraycopy(nums, left, temp, i, mid - left + 1);
//                break;
//            }
//            //选择较小的元素放入临时数组
//            if (nums[left] >= nums[right]) {
//                temp[i] = nums[right];
//                right++;
//                i++;
//            } else {
//                temp[i] = nums[left];
//                left++;
//                i++;
//            }
//        }
//        System.arraycopy(temp, 0, nums, begin, length);
//        //手动为临时数组去掉引用，方便连续的内存空间被及时回收
//        temp=null;
//    }
//
//
//
//    /**
//     * @Author Nxy
//     * @Date 2019/12/4
//     * @Param
//     * @Return
//     * @Exception
//     * @Description 链表并归排序
//     * 递归分解序列为两个子序列，并向上并归排序,返回排序后的总链表
//     * 使用快慢指针法，快指针到终点时慢指针指向中点
//     */
//    public static ListNode mergeSort(ListNode head) {
//        //回归条件
//        if (head.getNext() == null) {
//            return head;
//        }
//        //快指针,考虑到链表为2时的情况，fast比slow早一格
//        ListNode fast = head.getNext();
//        //慢指针
//        ListNode slow = head;
//        //快慢指针开跑
//        while (fast != null && fast.getNext() != null) {
//            fast = fast.getNext().getNext();
//            slow = slow.getNext();
//        }
//        //找到右子链表头元素，复用fast引用
//        fast = slow.getNext();
//        //将中点后续置空，切割为两个子链表
//        slow.setNext(null);
//        //递归分解左子链表,得到新链表起点
//        head = mergeSort(head);
//        //递归分解右子链表,得到新链表起点
//        fast = mergeSort(fast);
////        System.out.println(head.getValue()+"  "+fast.getValue());
//        //并归两个子链表
//        ListNode newHead = merge(head, fast);
////        ListNode.print(newHead);
//        return newHead;
//    }
//
//    /**
//     * @Author Nxy
//     * @Date 2019/12/4 14:48
//     * @Param
//     * @Return
//     * @Exception
//     * @Description 以left节点为起点的左子序列 及 以right为起点的右子序列 并归为一个有序序列并返回头元素；
//     * 传入的 left 及 right 都不可为 null
//     */
//    public static ListNode merge(ListNode left, ListNode right) {
//        //维护临时序列的头元素
//        ListNode head;
//        if (left.getValue() <= right.getValue()) {
//            head = left;
//            left = left.getNext();
//        } else {
//            head = right;
//            right = right.getNext();
//        }
//        //两个子链表均存在剩余元素
//        ListNode temp = head;
//        while (left != null && right != null) {
//            //将较小的元素加入临时序列
//            if (left.getValue() <= right.getValue()) {
//                temp.setNext(left);
//                left = left.getNext();
//                temp = temp.getNext();
//            } else {
//                temp.setNext(right);
//                right = right.getNext();
//                temp = temp.getNext();
//            }
//        }
//        //左子序列用完将右子序列余下元素加入临时序列
//        if (left == null) {
//            temp.setNext(right);
//        }
//        //右子序列用完将左子序列余下元素加入临时序列
//        if (right == null) {
//            temp.setNext(left);
//        }
//        ListNode.print(head);
//        return head;
//    }
}
