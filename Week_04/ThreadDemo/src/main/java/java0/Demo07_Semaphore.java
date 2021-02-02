package java0;

import java.util.concurrent.Semaphore;

/**
 * @author Leeyj
 * @date 2021/2/2 19:29
 */
public class Demo07_Semaphore {

    public static int result = 0;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        Semaphore sp = new Semaphore(0);

        new Thread(()->{
            result = CommonDemo.sum();
            sp.release();
        }).start();

        try {
            sp.acquire();

            System.out.println("异步计算结果为："+result);

            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

            System.out.println("Main End...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
