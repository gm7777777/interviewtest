package unsortelistgetkth;

import java.util.PriorityQueue;

public class UnsortedListGetKth {

    //利用调整堆
    public static int getKth(int[] nums,int k){

        PriorityQueue pq = new PriorityQueue();
        for(int i = 0; i<nums.length ; i++){
            int t = nums[i];
            pq.add(t);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return new Integer(pq.poll().toString()).intValue();
    }

    //利用分治算法
    public static int getKth1(int[] nums,int k){

        GetReasult(1,nums.length,k,nums);
        return 0;
    }

    //时间复杂度 n(k*logn)
    public static int checkKthNum(int start , int end,int[] nums){
        int l , r ,key;
        l = start;
        r = end;
        key = nums[start];
        while(l<r){
            while((l<r&&nums[r]>=key)) {
                r--;
            }
            nums[l] = nums[r];
            while((l<r&&nums[l]<=key)){
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = key;
        return l;
    }


    static void GetReasult(int start,int endd,int K,int[] nums) {
        if (start == endd) {
            return;
        } else {
            int num = 0;
            if (start < endd) {
                num = checkKthNum(start, endd, nums);
            }
            if (num == K) {
                return;
            }
            if (num > K) {
                GetReasult(start, num - 1, K, nums);
            } else {
                GetReasult(num + 1, endd, K, nums);
            }
        }
    }




    //得到第K个快排
    int ans = 0;  //答案
    void alter_quicksort(int[] a, int k, int low, int high) {
        int pivot = a[low];
        int low0 = low, high0 = high;
        while (low < high) {
            while (low < high && a[high] >= pivot) high--;
            a[low] = a[high];
            while (low < high && a[low] <= pivot) low++;
            a[high] = a[low];
        }
        a[low] = pivot;
        //上面几行都是常规的快排
        //下面的便是对快排的改造，只对左右区间中的一个区间进行递归，保证时间复杂度为O(n)，证明过程在算法导论9.2，我也没看懂哈哈哈
        if (low == a.length - k) {
            ans = a[low];
            return;
        }
        else if (low < a.length-k)
            alter_quicksort(a, k, low + 1, high0);
        else
            alter_quicksort(a, k, low0, low - 1);
    }
    int findKthLargest(int[] nums, int k) {
        alter_quicksort(nums,k,0,nums.length-1);
        return ans;
    }
}
