package findmajorityelement;

public class MajorityElement {

    //(有序数组数组中找出出现次数最多的元素)
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int count = 0;
        int max = nums[0];

        for(int i = 1; i < len; i++){
            if(max == nums[i]){
                count++;
            }else{
                count--;
                if(count == 0){
                    max = nums[i];
                    count++;
                }
            }
        }
        return max;
    }



}
