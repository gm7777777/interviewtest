package MergeGapRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
//
//
//        示例 1：
//
//        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//        输出：[[1,6],[8,10],[15,18]]
//        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//        示例 2：
//
//        输入：intervals = [[1,4],[4,5]]
//        输出：[[1,5]]
//        解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
public class MergeGapRange {

    public int[][] merge(int[][] intervals) {
        // 如果区间数组为空或者长度为 0，返回空数组
        if (intervals == null || intervals.length == 0) return new int[0][0];

        // 按照区间的左端点从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 创建一个结果数组用于存储不重叠区间
        List<int[]> res = new ArrayList<>();

        // 当前区间初始值设置为第一个区间
        int[] cur = intervals[0];

        // 遍历整个区间数组
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的右端点大于等于下一个区间的左端点，则更新当前区间的右端点
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                // 否则把当前区间加入到结果数组中
                res.add(cur);
                // 并将当前区间更新为下一个区间
                cur = intervals[i];
            }
        }
        // 把最后一个区间加入到结果数组中
        res.add(cur);

        // 将结果数组转换为 int[][] 类型并返回
        return res.toArray(new int[res.size()][2]);
    }
}
