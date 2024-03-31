package FindTwoArrayMedianNum;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
//        算法的时间复杂度应该为 O(log (m+n)) 。
//
//
//
//        示例 1：
//
//        输入：nums1 = [1,3], nums2 = [2]
//        输出：2.00000
//        解释：合并数组 = [1,2,3] ，中位数 2
//        示例 2：
//
//        输入：nums1 = [1,2], nums2 = [3,4]
//        输出：2.50000
//        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//到找两个数组中的中位数
public class FindTwoArrayMedianNum {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        double[] arrs = new double[n + m];
        int i = 0, j = 0, x = 0;
        int s = n + m;
        while (i < m && j < n && i + j <= s / 2) {
            if (nums1[i] >= nums2[j])
                arrs[x++] = nums2[j++];
            else
                arrs[x++] = nums1[i++];
        }
        while (i == m && i + j <= s / 2)
            arrs[x++] = nums2[j++];

        while (j == n && i + j <= s / 2)
            arrs[x++] = nums1[i++];
        if (s % 2 == 0) return (arrs[s / 2] + arrs[s / 2 - 1]) / 2;
        else return arrs[s / 2];
    }
}
