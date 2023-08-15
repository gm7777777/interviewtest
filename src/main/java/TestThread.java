import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class TestThread {
        public static volatile int NUM =3;

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(NUM);
        CountDownLatch counter1 = new CountDownLatch(NUM);

        for(int i =0;i<NUM;i++){

            new ShowThread(barrier,counter1).start();
        }
        try {
            counter1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ShowThread extends Thread{
        CyclicBarrier counter =null;
        CountDownLatch counter1 =null;
        ShowThread(CyclicBarrier counter,CountDownLatch counter1){
            this.counter = counter;
            this.counter1 = counter1;
        }

        @Override
        public void run(){

//            while(true&&NUM>0){
                System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    counter.await();
                    counter1.countDown();
                    System.out.println("线程"+counter1.getCount()+"正在写入数据...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

//            }

        }
    }
}
