package java0;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Leeyj
 * @date 2021/2/2 19:47
 */
public class Demo09_LockSupport {

    public static int result = 0;
    public static void main(String[] args) {
        long start=System.currentTimeMillis();


        Thread t1 = Thread.currentThread();
        new Thread(() -> {
            result = CommonDemo.sum();
            LockSupport.unpark(t1);
        }).start();

        LockSupport.park();

        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
