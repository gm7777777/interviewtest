import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
                int[] a = new int[]{1,3,5,2,2};//5,3

        a = new int[]{1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
                System.out.println(t.findKth(a,49,26));

//                int num = 0;
//        quickSort(a, 0, 48);
//        for(int j = 0;j<26;j++){
//          num = a[j];
//        }
//        System.out.println(num);

//        getKth1(a,24);

    }

        public int findKth(int[] a, int n, int K) {
            PriorityQueue pq = new PriorityQueue();
            for(int i = 0; i< a.length ; i++){
                int t = a[i];
                pq.add(t);
            }
            int num=0;
            for(int j = 0;j<K;j++){
                num = new Integer(pq.poll().toString()).intValue();
            }
            return  num;// write code here
        }


    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        temp = arr[low];

        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }


    //利用分治算法
    public static int getKth1(int[] nums,int k){

        GetReasult(1,nums.length-1,k,nums);
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
