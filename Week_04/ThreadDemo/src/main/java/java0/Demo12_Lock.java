package java0;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Leeyj
 * @date 2021/2/2 19:57
 */
public class Demo12_Lock {

    public static int result = 0;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        Lock lock1 = new ReentrantLock();

        Condition condition = lock1.newCondition();

        new Thread(() -> {
            lock1.lock();
            result = CommonDemo.sum();
            condition.signal();
            lock1.unlock();
        }).start();

        lock1.lock();

        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
        }

        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
