package dynamicprogram.numtowermaxpath;


//数字塔从上到下所有路径中和最大的路径
public class NumTowerMaxPath {
    public static int minNumberInRotateArray(int n[][]) {
        int max = 0;
        int dp[][] = new int[n.length][n.length];
        dp[0][0] = n[0][0];
        for (int i = 1; i < n.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    //如果是第一列，直接跟他上面数字相加
                    dp[i][j] = dp[i - 1][j] + n[i][j];
                } else {
                    //如果不是第一列，比较他上面跟上面左面数字谁大，谁大就跟谁相加，放到这个位置
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + n[i][j];
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
    }
