package minnuminrotatearray;

//利用二分法求解
public class MinNumberInRotateArray {

    public static int getMinNum(int[] nums){

        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid = low +(high-low)/2;
            if(nums[mid]>nums[high]){
                    low = mid+1;
            }else if(nums[mid] == nums[high]){
                    high = high-1;
            }else{
               high = mid;
            }
        }
        return nums[low];
    }

    public static int myBinarySearch(int[] arr,int value) {
        int low=0;
        int high=arr.length-1;
        while(low<=high) {
            int mid=(low+high)/2;
            if(value==arr[mid]) {
                return mid;
            }
            if(value>arr[mid]) {
                low=mid+1;
            }
            if(value<arr[mid]) {
                high=mid-1;
            }

        }
        return -1;//没有找到返回-1
    }

}
