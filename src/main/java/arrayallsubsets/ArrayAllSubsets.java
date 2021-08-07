package arrayallsubsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//数组的所有子序列
public class ArrayAllSubsets {

    public static void main(String[] args) {
//        int[] nums = {1,3,4,5,7,8,9,6,3};
//        int[] nums = {1,3,4};
        int[] nums = {1,3,4};
        Set<Set<Integer>> res = new HashSet<>();
        getRestGroup(res, new HashSet(),0,nums);

        System.out.println(res);
    }

    public static void getRestGroup(Set<Set<Integer>> alllist , Set grouplist, int index, int[] sums){
//        if(index<=sums.length){
            alllist.add(new HashSet<>(grouplist));
//        }
//        alllist.add(new ArrayList<>(grouplist));
        for(int i = index;i<sums.length;i++){
            int t = sums[i];
            Set tgrouplist = (Set) ((HashSet)grouplist).clone();
            tgrouplist.add(t);

//            if(!alllist.isEmpty()){
//                ArrayList<ArrayList> tempAll = (ArrayList) alllist.clone();
//                for(ArrayList tempList :tempAll){
////                    if((tempList.size())==index&&(tempList.size()>0&&(int)tempList.get(tempList.size()-1)!=t)){
//                    if((tempList.size())==index){
//                        tempList = new ArrayList<>(tempList);
//                        tempList.add(t);
//                        getRestGroup(alllist,tempList,index+1,sums);
//                    }
//                }
//            }
//            if (grouplist.size()>1&&t==(int)grouplist.get(grouplist.size()-2)) {
//                grouplist.remove(grouplist.size()-1);
//            }
            getRestGroup(alllist,tgrouplist,index+1,sums);
//            grouplist.remove(grouplist.size()-1);
        }

    }
}

