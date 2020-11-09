package unsortedlistfindtwonumandn;

import java.util.HashMap;
import java.util.Map;

public class UnsortedListTwoNumAndN {

        public static void main(String[] args) {
            int[] arr = new int[]{3, 4, 6, 5, 9, 8};
            int num = 8;
            int[] ret = getIndex(arr, num);
            System.out.println("index of two numbers R:" + ret[0] + " " + ret[1]);
        }
        // 找到这两个数的下标并返回（以长度为2的数组的形式返回）
        private static int[] getIndex(int[] arr, int num) {
            int[] ret = new int[2];
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int index = 0;
            // 将每个数字和其下标放进map中
            for (Integer curr : arr) {
                hashMap.put(curr, index++);
            }
            // 遍历HashMap并判断
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                int value = entry.getKey();
                int subValue = num - value;
                if(hashMap.containsKey(subValue)) {
                    // 找到啦!
                    ret[0] = entry.getValue();
                    ret[1] = hashMap.get(subValue);
                    break;
                }
            }
            return ret;
        }



//    public:
//    static bool myfun(const pair<int, int> a, const pair<int, int> b)
//    {
//        return a.first < b.first;
//    }
//
//    vector<int> twoSum(vector<int> &numbers, int target) {
//
//        int i,j;
//        vector< pair<int, int> > index;
//        for(i=0;i<numbers.size();i++)
//        {
//            pair<int, int> tmp;
//            tmp.first = numbers[i];
//            tmp.second = i+1;
//            index.push_back(tmp);
//        }
//        sort(index.begin(), index.end(), myfun);
//
//        i = 0;
//        j = index.size() - ;
//        while(i<j)
//        {
//            if(index[i].first + index[j].first >target)
//                j--;
//            else if(index[i].first + index[j].first <target)
//                i++;
//            else
//                break;
//        }
//
//        vector<int> result;
//        int idx1,idx2;
//        if(index[i].second < index[j].second)
//        {
//            idx1 = index[i].second;
//            idx2 = index[j].second;
//        }
//        else
//        {
//            idx2 = index[i].second;
//            idx1 = index[j].second;
//        }
//
//        result.push_back(idx1);
//        result.push_back(idx2);
//        return result;
//    }

}
