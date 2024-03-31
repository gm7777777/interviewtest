package fibonacociarray;

public class FibonacociArray {
    public static int fib(int n) {
        if(n<=2){return 1;}
        return fib(n-1)+fib(n-2);
    }
    //非递归实现斐波那契数列
    public static int fib2(int n) {
        if(n<=2){return 1;}
        int first=1;
        int second=1;
        int sum=0;
        while(n>2) {
            sum=first+second;
            first=second;
            second=sum;
            n--;
        }
        return second;
    }

    //爬楼梯
    public int climbStairs(int n) {
        int[] nums = new int[45];
        nums[0] = 1;
        nums[1] = 2;
        for(int i =2; i < n; i++){
            nums[i]= nums[i-1]+nums[i-2];
        }
        return nums[n-1];
    }
}
