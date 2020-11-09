package blockqueuemethod;

public class BlockQueueMethod {

//    public void put(E e) throws InterruptedException {
//        checkNotNull(e);
//        final ReentrantLock lock = this.lock;
//        lock.lockInterruptibly();
//        try {
//            while (count == items.length)
//                notFull.await();
//            enqueue(e);
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    private void enqueue(E x) {
//        // assert lock.getHoldCount() == 1;
//        // assert items[putIndex] == null;
//        final Object[] items = this.items;
//        items[putIndex] = x;
//        if (++putIndex == items.length)
//            putIndex = 0;
//        count++;
//        notEmpty.signal();
//    }
//
//    public E take() throws InterruptedException {
//        final ReentrantLock lock = this.lock;
//        lock.lockInterruptibly();
//        try {
//            while (count == 0)
//                notEmpty.await();
//            return dequeue();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    private E dequeue() {
//        // assert lock.getHoldCount() == 1;
//        // assert items[takeIndex] != null;
//        final Object[] items = this.items;
//        @SuppressWarnings("unchecked")
//        E x = (E) items[takeIndex];
//        items[takeIndex] = null;
//        if (++takeIndex == items.length)
//            takeIndex = 0;
//        count--;
//        if (itrs != null)
//            itrs.elementDequeued();
//        notFull.signal();
//        return x;
//    }
//
////        2.使用Synchronized来实现一个BlockingQueue
////    和上面一个思想，利用锁wait和notifyAll来实现一个容量为0-10的BlockingQueue
//
//    LinkedList<Integer> list = new LinkedList();
//
//    public int take() throws InterruptedException {
//        synchronized (list) {
//            System.out.println(Thread.currentThread().getName() + "-- reduce --> " + list.size());
//            while (list.size() == 0) {
//                System.out.println("空了");
//                list.wait();
//            }
//            list.notifyAll();
//            return list.remove();
//        }
//    }
//
//    public void put(Integer i) throws InterruptedException {
//        synchronized (list) {
//            System.out.println(Thread.currentThread().getName() + "-- add --> " + list.size());
//            while (list.size() == 10) {
//                System.out.println("满了");
//                list.wait();
//            }
//            list.notifyAll();
//            list.add(i);
//        }
//    }
//
//    public int size() {
//        synchronized (list) {
//            return list.size();
//        }
//    }
}
