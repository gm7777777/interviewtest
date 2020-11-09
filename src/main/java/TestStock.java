import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TestStock {

    public static void main(String args[]) {
        int[] prices = new int[]  {4,4,6,1,1,4,2,5};
        System.out.println(getKthProfit(prices,2));
    }


    /**
     * 利用贪心算法算出已每一天为基准所有股票获利方式取其中最多k组
     * @param stocks
     * @param k
     * @return
     */
    public static int getKthProfit(int[] stocks , int k){
        if(stocks.length<=1){
            return 0;
        }
        List temp = new ArrayList();
        int res0=0,min=stocks[0];
        for(int i=1;i<stocks.length;i++)
        {
            if(stocks[i]>min)
            {
                res0=stocks[i]-min;
                temp.add(res0);
                min=stocks[i];
            }
            else {
                min = stocks[i];
            }
        }
        Collections.sort(temp);
        int sum = 0;
        for(int j = temp.size()-k ; j< temp.size();j++){
            sum =sum+ (int)temp.get(j);
        }
        return sum;
    }
}
