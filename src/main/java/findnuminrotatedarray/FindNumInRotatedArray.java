package findnuminrotatedarray;

//旋转有序数组中查找某个数
public class FindNumInRotatedArray {

    int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

//    示例 1：
//
//    输入：nums = [4,5,6,7,0,1,2], target = 0
//    输出：4
//    示例 2：
//
//    输入：nums = [4,5,6,7,0,1,2], target = 3
//    输出：-1
//    示例 3：
//
//    输入：nums = [1], target = 0
//    输出：-1

    public int search1(int[] nums, int target) {
        int result=-1;
        int left=nums.length-1;
        int right=0;
        while(left>=right){
            if(nums[left]==target){
                result=left;
                break;
            }else if(nums[right]==target){
                result=right;
                break;
            }else{
                left--;
                right++;
            }
        }
        return result;
    }

}
