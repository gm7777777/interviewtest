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
}
