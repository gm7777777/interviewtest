package findlackposint;

//缺失第一个正整数
//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//
//        请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//示例 1：
//
//        输入：nums = [1,2,0]
//        输出：3

//        示例 2：
//
//        输入：nums = [3,4,-1,1]
//        输出：2

//        示例 3：
//
//        输入：nums = [7,8,9,11,12]
//        输出：1
public class FindLackPositiveInt {

    public static void main(String[] args) {
        int[] temp = {7,8,9,11,12};
        System.out.println(firstMissingPositive(temp));
    }
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 众神归位
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n) {
                int pos = nums[i] - 1;
                // 交换 i 和 pos
                if (nums[i] == nums[pos]) break; // 已经在对应位置
                int t = nums[i];
                nums[i] = nums[pos];
                nums[pos] = t;
            }
        }
        // 找第一个
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}
