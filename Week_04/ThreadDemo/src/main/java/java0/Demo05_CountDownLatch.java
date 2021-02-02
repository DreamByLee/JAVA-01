package java0;

import java.util.concurrent.CountDownLatch;

/**
 * @author Leeyj
 * @date 2021/2/1 22:02
 */
public class Demo05_CountDownLatch {

    public static int result = 0;

    public static void main(String[] args) throws InterruptedException{
        long start=System.currentTimeMillis();

        CountDownLatch cdl = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {

            result = CommonDemo.sum();
            cdl.countDown();//减计数

        });

        t1.start();
        cdl.await();
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
