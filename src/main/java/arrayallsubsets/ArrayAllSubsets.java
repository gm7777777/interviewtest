package arrayallsubsets;

import java.util.*;

//数组的所有子序列
public class ArrayAllSubsets {

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,7,8,9,6,3};
//        int[] nums = {1,3,4};
//        int[] nums = {1,3,4};
        Set<Set<Integer>> res = new HashSet<>();
        getRestGroup(res, new HashSet(),0,nums);

        System.out.println(res);
    }

    public static void getRestGroup(Set<Set<Integer>> alllist , Set grouplist, int index, int[] sums){

            alllist.add(new HashSet<>(grouplist));


        for(int i = index;i<sums.length;i++){
            int t = sums[i];
            Set tgrouplist = (Set) ((HashSet)grouplist).clone();
            tgrouplist.add(t);

            getRestGroup(alllist,tgrouplist,index+1,sums);

        }

    }
}

