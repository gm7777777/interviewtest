package mergeKsortedlist;

import com.common.Node;

import java.util.PriorityQueue;

public class MergeKSortedList {

//    解法一：分治，利用上一题的合并两个有序链表的方法，利用分治达到目的，不过左边和右边有三种情况：
//
//    left=right-1:这时候right–，同时令left=0
//    left=right-2 这时候right还是–，同时令left=0；
//    不是上面两个条件，证明不是上面的内容，即没有到链表遍历完成


    public Node mergeKLists(Node[] lists) {
        if(lists.length==0) {
            return null;
        }
        int left = 0;
        int right = lists.length-1;
        while (left<right){
            lists[left] = mergeTwoLists(lists[left],lists[right]);
            if (left==right-1){
                left = 0;
                right--;
            }else if(left==right-2){
                left = 0;
                right--;
            }else {
                left++;
                right--;
            }
        }
        return lists[0];
    }
    public Node mergeTwoLists(Node l1, Node l2) {
        Node l3 = new Node(0);
        Node l4 = l3;
        while(l1!=null&&l2!=null)
        {
            if(l1.value>l2.value)
            {
                l3.next = l2;
                l2 = l2.next;
            }else{
                l3.next = l1;
                l1 = l1.next;
            }
            l3 = l3.next;
        }
        if(l1==null)
        {
            l3.next = l2;
        }else{
            l3.next = l1;
        }
        return l4.next;
    }



    //利用优先队列 贪心算法
    public Node mergeKLists1(Node[] lists) {
        if(lists == null || lists.length < 0){
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue();
        for(Node node:lists){
            while(node != null){
                queue.add(node.value);
                node = node.next;
            }
        }
        Node res = new Node(0);
        Node tmp= res;
        while(!queue.isEmpty()){
            Node temp = new Node(queue.poll());
            tmp.next = temp;
            tmp = tmp.next;
        }
        return res.next;
    }

















//    public static void main(String[] args) {
//        int[] a = { -1, 5, 9, 15, 85, 98, 100 };
//        int[] b = { -2, 6, 8, 14, 73, 85, 97 };
//        System.out.println(checkSort(a));
//        sort(a);
//        System.out.println(checkSort(a));
//        System.out.println(Arrays.toString(merge(a, b)));
//
//    }

    public static boolean checkSort(int[] a) {
        // 使用插入排序进行验证
        for (int x = 0; x < a.length - 1; x++) {
            for (int y = x; y > 0; y--) {
                if (a[y - 1] > a[y]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void sort(int[] a) {
        // 使用了插入排序
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        if (checkSort(a) && checkSort(b)) {
            // 两个数组都处于排序状态
            int i = 0, j = 0, k = 0;
            while (i <= a.length - 1 && j <= b.length - 1) {
                // 两个数组都没有数据用完
                if (a[i] <= b[j])
                    result[k++] = a[i++];
                if (b[j] < a[i])
                    result[k++] = b[j++];
            }
            // a数组未用完，b数组用完了
            while (i <= a.length - 1 && j > b.length - 1) {
                result[k++] = a[i++];
            }
            // b数组未用完，a数组用完了
            while (j <= b.length - 1 && i > a.length - 1) {
                result[k++] = b[j++];
            }
        } else {
            // 如果数组a属于非排序状态则对a进行排序
            if (!checkSort(a))
            { sort(a);}
            // 如果数组b属于非排序状态则对b进行排序
            if (!checkSort(a))
            { sort(b);}
            merge(a, b);
        }
        return result;
    }


}
