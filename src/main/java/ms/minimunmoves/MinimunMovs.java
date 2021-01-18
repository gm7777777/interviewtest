package ms.minimunmoves;

//给一个字符串，每次可以移除其中一个字符，或者移除一个回文子串，求 全部移除所需最少次数#
//        例如：1，4，3，1，5. 先移除 3，再移除 1 4 1，再移除 5，得到最少次数 3.

public class MinimunMovs {

    //动态规划。在原来题解的基础上，加了注释。
    public static int minimumMoves(int[] arr) {
        int n = arr.length;
        //dp[i][j]表示删除从i到j的数字所需的最少操作次数
        int[][] dp = new int[n + 1][n + 1];
        //l表示当前数字的长度
        for (int l = 1; l <= n; l++) {
            int i = 0, j = l - 1;
            while (j < n) {
                if (l == 1) {
                    //base，每个数字的删除次数为1
                    dp[i][j] = 1;
                } else {
                    //不考虑回文子串的情况下，删除次数为之前的删除次数+1
                    dp[i][j] = 1 + dp[i + 1][j];
                    //考虑回文子串
                    for (int k = i + 1; k <= j; k++) {
                        if (arr[i] == arr[k]) {
                            //更新dp[i][j]
                            dp[i][j] = Math.min(dp[i][j], dp[i + 1][k - 1] + dp[k + 1][j] + (i + 1 == k ? 1 : 0));
                        }
                    }
                }
                i++;
                j++;
            }
        }
        return dp[0][n - 1];

    }
}
