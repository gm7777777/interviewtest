package cutbiggestchocolate;

import java.util.PriorityQueue;

public class CutBiggestChocolate {
//    你有一大块巧克力，它由一些甜度不完全相同的小块组成。我们用数组 sweetness 来表示每一小块的甜度。
//
//    你打算和 K 名朋友一起分享这块巧克力，所以你需要将切割 K 次才能得到 K+1 块，每一块都由一些 连续 的小块组成。
//
//    为了表现出你的慷慨，你将会吃掉 总甜度最小 的一块，并将其余几块分给你的朋友们。
//
//    请找出一个最佳的切割策略，使得你所分得的巧克力 总甜度最大，并返回这个 最大总甜度
//    示例 1：
//
//    输入：sweetness = [1,2,3,4,5,6,7,8,9], K = 5
//    输出：6
//    解释：你可以把巧克力分成 [1,2,3], [4,5], [6], [7], [8], [9]。
//            1
//            2
//            3
//    示例 2：
//
//    输入：sweetness = [5,6,7,8,9,1,2,3,4], K = 8
//    输出：1
//    解释：只有一种办法可以把巧克力分成 9 块。
//            1
//            2
//            3
//    示例 3：
//
//    输入：sweetness = [1,2,2,1,2,2,1,2,2], K = 2
//    输出：5
//    解释：你可以把巧克力分成 [1,2,2], [1,2,2], [1,2,2]。
//            1
//            2
//            3
//

    //5,8,10,11,12,33 2
    public static void main(String[] args) {
//        int[] a1 = {5,8,10,11,12,33};
//        System.out.println(maximizeSweetness(a1,2));
        int[] a1 = {1,2,3,4,5,6,7,8,9};
        System.out.println(cutBiggestChocolate(a1,5));
        System.out.println(maximizeSweetness(a1,5));
        System.out.println(maximizeSweetness1(a1,5));
        int[] a2 = {5,6,7,8,9,1,2,3,4};
        System.out.println(cutBiggestChocolate(a2,8));
        System.out.println(maximizeSweetness(a2,8));
        System.out.println(maximizeSweetness1(a2,8));
        int[] a3 = {1,2,2,1,2,2,1,2,2};
        System.out.println(cutBiggestChocolate(a3,2));
        System.out.println(maximizeSweetness(a3,2));
        System.out.println(maximizeSweetness1(a3,2));
    }

    public static int cutBiggestChocolate(int[] arr ,int K){
       int sum = 0;
        for(int i =0;i<arr.length;i++){
            sum= sum+arr[i];
        }
        int avg = sum/(K+1);
        while(avg>0){
            int cutnum = 0;
            int cutsum= 0;
            for(int cut:arr){
                cutsum +=cut;
                if(cutsum>=avg){
                    if(cutnum==K){
                        return avg;
                    }
                    cutnum++;
                    cutsum=0;
                }
            }
            avg--;
        }
        return avg;
    }



    public static int maximizeSweetness(int[] sweetness, int K) {
        // sum 该数组总和
        int sum = 0;
        for (int swt : sweetness) {
            sum += swt;
        }

        // avg 如果平均分给K+1个人
        int avg = sum / (K + 1);
        while (avg > 0) {
            // cur 当前分块个数
            // curSum 每个分块的大小
            int cur = 0, curSum = 0;
            for (int swt : sweetness) {
                curSum += swt;
//                System.out.printf("cut:%d K:%d curSum:%d avg:%d\n", cur, K, curSum, avg);
                if (curSum >= avg) {
//                    System.out.println();
                    // 从第0块开始切 (cur++ > K or ++cur > (K+1))
                    if (cur++ >= K) {
                        return avg;
                    }
                    curSum = 0;
                }
            }
            // 以步长为1的"速度"向最佳答案靠近
            avg--;
        }

        return avg;
    }


    public static int maximizeSweetness1(int[] sweetness, int K) {
        // ans 返回答案
        // left 二分左值
        // right 二分右值 大小为1e4*1e5
        int ans = 0, left = 0, right = (int) 1e9 + 50;

        // 最佳甜度必定在[left, right]区间内
        while (left <= right) {
            int mid = (left + right) >> 1;
            // 检测: 以mid为界限, 大于它的都不可以, 小于等于则可以
            if (check(sweetness, K + 1, mid)) {
                // 最佳mid值在后半段 [mid+1, right]
                left = mid + 1;
                ans = Math.max(mid, ans);
            } else {
                // 最佳mid值在前半段 [left, mid-1]
                right = mid - 1;
            }
        }

        return ans;
    }

    private static boolean check(int[] arr, int len, int threshold) {
        // cur 在分块总和满足阈值threshold的情况下 可切块数量 --> k+1
        // sum 单分块之和
        int cur = 0, sum = 0;

        for (int a : arr) {
            sum += a;
            // 该连续块之和符合阈值 予以分块
            if (sum >= threshold) {
                cur++;
                sum = 0;
            }
        }

        // 如果在阈值threshold下 可以分成k+1块 该切割策略符合题意
        return cur >= len;
    }


    public int maximizeSweetness3(int[] sweetness, int K) {
        int sum = 0;
        for (int swt : sweetness) {
            sum += swt;
        }

        // right 采用平均值
        int left = 0, right = sum / (K + 1), ans = 0;

        while (left <= right) {
            int mid = (left + right) >> 1, cur = 0, curSum = 0;
            System.out.printf("[left:%d mid:%d right:%d]\n", left, mid, right);
            for (int swt : sweetness) {
                curSum += swt;
                System.out.printf("[cut:%d K:%d] [curSum:%d mid:%d]\n", cur, K, curSum, mid);
                if (curSum >= mid) {
                    if (cur++ >= K) {
                        break;
                    }
                    curSum = 0;
                }
            }

            if (cur > K) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
