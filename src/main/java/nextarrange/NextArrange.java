package nextarrange;

import java.util.Arrays;

//下一个排列
//示例 1：
//
//        输入：nums = [1,2,3]
//        输出：[1,3,2]
//        示例 2：
//
//        输入：nums = [3,2,1]
//        输出：[1,2,3]
//        示例 3：
//
//        输入：nums = [1,1,5]
//        输出：[1,5,1]

public class NextArrange {

    public static void nextPermutation(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                l = i;
            }
        }
        for (int i = l + 1 ; i < nums.length; i++) {
            if (nums[i] > nums[l]) {
                r = i;
            }
        }
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        Arrays.sort(nums,l + 1,nums.length);
        return;
    }
}
