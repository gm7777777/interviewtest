import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
public class TestThread {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        AtomicInteger temp = new AtomicInteger(0);
        new Thread(new ThreadA(temp)).start();
        new Thread(new ThreadB(temp)).start();
        new Thread(new ThreadC(temp)).start();
    }


    static class ThreadA implements Runnable{

        AtomicInteger num = null;
        public ThreadA(AtomicInteger num){
            this.num = num;
        }
        @Override
        public void run(){
            int sum =20;
            while(true){
                if(num.intValue()==0&&sum>0){
                    System.out.println("A");
                    num.getAndIncrement();
                    sum--;
                }
            }
        }
    }
    static class ThreadB implements Runnable{

        AtomicInteger num = null;
        public ThreadB(AtomicInteger num){
            this.num = num;
        }
        @Override
        public void run(){
            int sum =20;
            while(true) {
                if (num.intValue() == 1 && sum > 0) {
                    System.out.println("B");
                    num.getAndIncrement();
                    sum--;
                }
            }
        }
    }

    static class ThreadC implements Runnable{

        AtomicInteger num = null;
        public ThreadC(AtomicInteger num){
            this.num = num;
        }
        @Override
        public void run(){
            int sum =20;
            while(true) {
                if (num.intValue() == 2 && sum > 0) {
                    System.out.println("C");
//                num.getAndSet(0);
                    
                    sum--;
                }
            }
        }
    }
}
