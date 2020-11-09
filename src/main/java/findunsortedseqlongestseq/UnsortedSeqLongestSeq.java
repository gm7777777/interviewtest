package findunsortedseqlongestseq;

import java.util.HashMap;
import java.util.Map;

//查找无序数组中最长的有序字符串
public class UnsortedSeqLongestSeq {

    public static void main(String[] args) {

        int[] sums = {100,4,200,1,3,2};

        Map data = new HashMap();

        for(int i = 0 ; i < sums.length ; i++){
            int t = sums[i];
            data.put(t,1);
            int l = t;
            while(data.get(l-1)!=null){
                int lv = (Integer)data.get(l-1);
                data.put(l,(Integer)data.get(l)+lv);
                data.remove(l-1);
                l = l-1;
            }
            int r = t;
            while(data.get(r+1)!=null){
                int rv = (Integer)data.get(r+1);
                data.put(r,(Integer)data.get(r)+rv);
                data.remove(r+1);
                r = r+1;
            }
        }
        Integer biggestvalue= 0;
        for(Object obj : data.values()){
            if((Integer)obj >= biggestvalue){
                biggestvalue = (Integer)obj;
            }
        }
        System.out.println(biggestvalue);
    }
}
