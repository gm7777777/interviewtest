import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
public class TestThread {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
//        AtomicInteger temp = new AtomicInteger(0);
//        new Thread(new ThreadA(temp)).start();
//        new Thread(new ThreadB(temp)).start();
//        new Thread(new ThreadC(temp)).start();

//        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
//        for(int i = 0 ; i < 4;i++){
//            new Thread(new ThreadBarrier(cyclicBarrier)).start();
//        }

//        Semaphore semaphore = new Semaphore(1);
//        try {
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        semaphore.release();
    }


    static class ThreadBarrier implements Runnable{
        CyclicBarrier cyclicBarrier =null;
        public ThreadBarrier(CyclicBarrier cyclicBarrier){this.cyclicBarrier = cyclicBarrier;}
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.print(cyclicBarrier.getParties());

        }
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
