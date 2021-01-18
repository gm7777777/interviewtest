package dynamicprogram.findchange;

//具体思路同背包问题，这里只分析一下动态转化方程，能用这种零钱，分为用了这种零钱的方法跟没用到这种零钱的方法，dp[i][j] = dp[i-1][j] + dp[i][j-num[i]]；如果不能用这种零钱，即所组成的面额小于当前零钱，直接等于不用这种零钱的数值，dp[i][j] = dp[i-1][j]。这里要特别注意的是。1、开始填写二维数组边界值时，第一行是填写只用第一种面额零钱组成相应数额的方法，要注意是总数额除以第一种面额取余为0才能组成，即如果第一种面额为2，不能组成3,5的数额等；2、填写二维数组第一列时，代表到用到面额为i时，剩余数额为0，即只用i就可以组成相应数额，这也是一种方法，所以第一列的值，第一个为0，后面全为1.
public class FindChange {

    public static int SmallMoney(int num[], int target) {
        int m = num.length;
        int dp[][] = new int[m][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= target; i++) {
            if (i % num[0] == 0) {
                dp[0][i] = 1;//第一行数值填写
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;//第一列数值填写
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < num[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - num[i]];
                }
            }
        }
        return dp[m-1][target];
    }
}