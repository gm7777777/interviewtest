package randomNonAdMaxProfit;

import java.util.*;

public class RandomNonAdMaxProfit {
    public static void main(String[] args) {

        int[] a = {1,23,46,68,89,45,457,78,34};
//        int[] a = {1,23,46,68};
        Set data = new HashSet<>();
        getAllProfitSet(data,new HashMap<>(),a);
        System.out.println(Arrays.asList(data));
    }

    public static void  getAllProfitSet(Set<Map<Integer,Integer>> allSet, HashMap<Integer,Integer> groupMap, int[] arry){

        for(int i  =0 ;i < arry.length;i++){
            HashMap temp = null;
            if(groupMap.isEmpty()){
                temp = new HashMap();
            }else{
                temp = (HashMap) groupMap.clone();
            }
            //rule
            int t = arry[i];
            if(t>0){
                temp.put(i,t);
                int[] temparry = arry.clone();
                temparry[i]=-1;
                if((i-1)>=0){
                    temparry[i-1]=-1;
                }
                if((i+1)<arry.length){
                    temparry[i+1]=-1;
                }
                getAllProfitSet(allSet,  temp, temparry);
                allSet.add(temp);
            }
        }
    }
}
