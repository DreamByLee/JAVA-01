package java0;

/**
 * @author Leeyj
 * @date 2021/2/1 21:25
 */
public class Demo02_WaitAndNotify {


    public static int result = 0;
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        long start=System.currentTimeMillis();

        Thread t1 = new Thread(()->{
            synchronized (obj) {
                result = CommonDemo.sum();
                obj.notify();
            }

        });
        t1.start();

        synchronized (obj) {
            obj.wait();
            System.out.println("异步计算结果为："+result);

            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

            System.out.println("Main End...");
        }
    }
}
