package FindAscendSubArray;


//最长递增子序列
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
//        子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
//
//
//        示例 1：
//
//        输入：nums = [10,9,2,5,3,7,101,18]
//        输出：4
//        解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//        示例 2：
//
//        输入：nums = [0,1,0,3,2,3]
//        输出：4
//        示例 3：
//
//        输入：nums = [7,7,7,7,7,7,7]
//        输出：1
public class FindAscendSubArray {

    public int lengthOfLIS(int[] nums) {
        /**
         dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
         由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
         对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
         1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
         数组尾部, 并将最长递增序列长度maxL加1
         2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
         **/
        int maxL = 0;
        int[] dp = new int[nums.length];
        for(int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int lo = 0, hi = maxL;
            while(lo < hi) {
                int mid = lo+(hi-lo)/2;
                if(dp[mid] < num)
                    lo = mid+1;
                else
                    hi = mid;
            }
            dp[lo] = num;
            if(lo == maxL)
                maxL++;
        }
        return maxL;
    }
}
