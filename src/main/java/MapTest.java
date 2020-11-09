import java.util.HashMap;
import java.util.Map;

public class MapTest {
    //pattern = "abbc", str="蚂蚁 金融 金融 云服务" 返回 ture
//pattern = "aabb", str="蚂蚁 金融 金融 云服务" 返回 false
//pattern = "abc", str="蚂蚁 金融 金融 云服务" 返回 false
    public static boolean filterPatternStr(String pattern , String str){

        if(pattern==null||"".equals(pattern)){
            return false;
        }

        if(str==null||"".equals(str)){
            return false;
        }

        String[] dataStrs = str.split(" ");

        if(pattern.length()!=dataStrs.length){
            return false;
        }
        Map dataMap = new HashMap();

        char tempP = pattern.charAt(0);
        String tempS = dataStrs[0];
        dataMap.put(tempP,tempS);
        for(int i = 0; i <pattern.length();i++){
            String tempS2 = dataStrs[i];
            if(tempP!=pattern.charAt(i)){
                tempS = tempS2;
                dataMap.put(tempP,tempS);
            }else{
                if(!tempS.equals(tempS2)){
                    return false;
                }
            }

            tempP=pattern.charAt(i);
            if(dataMap.containsKey(tempP)){
                tempS = (String) dataMap.get(tempP);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String pattern = "abbc", str="蚂蚁 金融 金融 云服务";
        String pattern1 = "aabb", str1="蚂蚁 金融 金融 云服务";
        String pattern2 = "abc", str2="蚂蚁 金融 金融 云服务";

       System.out.println(filterPatternStr(pattern,str));
        System.out.println(filterPatternStr(pattern1,str1));
        System.out.println(filterPatternStr(pattern2,str2));

    }
}
