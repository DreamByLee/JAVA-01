package java0;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author Leeyj
 * @date 2021/2/1 22:09
 */
public class Demo06_CyclicBarrier {

    public static int result = 0;

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        long start=System.currentTimeMillis();

        CyclicBarrier cb = new CyclicBarrier(2);
        Thread t1 = new Thread(() -> {

            try {
                result = CommonDemo.sum();
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        cb.await();

        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
