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
}
