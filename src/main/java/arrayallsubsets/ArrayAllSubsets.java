package arrayallsubsets;

import java.util.ArrayList;
import java.util.List;

public class ArrayAllSubsets {

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,7,8,9,6,3};

        List<List<Integer>> res = new ArrayList<>();
        getRestGroup(res, new ArrayList(),0,nums);

        System.out.println(res);
    }

    public static void getRestGroup(List<List<Integer>> alllist , List grouplist,int index,int[] sums){
            alllist.add(new ArrayList<>(grouplist));
        for(int i = index;i<sums.length;i++){
            int t = sums[i];
            grouplist.add(t);
            getRestGroup(alllist,grouplist,index+1,sums);
            grouplist.remove(grouplist.size()-1);
        }
    }
}
