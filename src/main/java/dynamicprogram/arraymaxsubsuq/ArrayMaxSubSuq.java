package dynamicprogram.arraymaxsubsuq;


//数组最大连续子序列和
public class ArrayMaxSubSuq {

    public static int MaxContinueArraySum(int a[]) {
        int n = a.length;
        int max = a[0];
        int sum = a[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + a[i], a[i]);
            if (sum >= max) {
                max = sum;
            }
        }

        return max;
    }
}
