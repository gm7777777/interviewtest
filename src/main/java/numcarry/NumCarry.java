package numcarry;

import java.util.*;

public class NumCarry {

    public static void main(String[] args) {
//        int sum=1001;
//        List data = new ArrayList();
//        getNumState(sum,10,data,0);
//        System.out.println(Arrays.toString(data.toArray()));
        int sum=2601;
        List data = new ArrayList();
        getNumState(sum,26,data,0);
        System.out.println(Arrays.toString(data.toArray()));
    }

    static Map charMap = new HashMap(){
        {
            put(1,'A');put(2,'B');put(3,'C');put(4,'D');put(5,'E');
            put(6,'F');put(7,'G');put(8,'H');put(9,'I');put(10,'J');
            put(11,'K');put(12,'L');put(13,'M');put(14,'N');put(15,'O');
            put(16,'P');put(17,'Q');put(18,'R');put(19,'S');put(20,'T');
            put(21,'U');put(22,'V');put(23,'W');put(24,'X');put(25,'Y');
            put(26,'Z');
        }
    };

    public static void getNumState(int sum,int carryval,List sumList,int state){
        int tsum = sum;
        int mins = 1;
        boolean flag = false;
        if(state==0){
            flag = true;
        }
        if(tsum<carryval&&state==0){
            sumList.add( charMap.get(tsum));
            return ;
        }

        while(tsum>=carryval){
             tsum = tsum/carryval;
             mins = mins*carryval;
             if(true){
                 state++;
             }
        }
        if(sum<carryval&&state!=0){
            sumList.add( 0);
        }else{
            sumList.add( charMap.get(tsum));
            sum = sum - tsum*mins;
        }
        state--;
        getNumState(sum,carryval,sumList,state);
    }
}
