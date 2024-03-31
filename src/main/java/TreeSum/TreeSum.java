package TreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//数组中找寻 三个数相加为0组合
public class TreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
//结果集
        ArrayList<List<Integer>> res = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //若定的最小元素大于0，那找三数之和一定大于0
            if (nums[i] > 0) {
                break;
            }
            //去重：若当前元素与前一个元素相等，得到的结果前一次已经得到了
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            while (l < r) {
                int num = nums[i]+nums[l]+nums[r];
                if (num == 0) {
                    //去重
                    while (l<r&&nums[r]==nums[r-1]){
                        r--;
                    }
                    //去重
                    while (l<r&&nums[l]==nums[l+1]){
                        l++;
                    }
                    //添加到结果集
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    r--;
                    l++;
                }
                //因为有序，若大于0，则r--
                else if (num > 0) r--;
                    //小于0，则l++
                else l++;
            }
        }
        return res;
    }

}
