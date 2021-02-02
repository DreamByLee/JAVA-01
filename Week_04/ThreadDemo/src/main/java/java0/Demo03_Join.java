package java0;

/**
 * @author Leeyj
 * @date 2021/2/1 21:35
 */
public class Demo03_Join {

    public static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();

        Thread t1 =new Thread(()->{
            result = CommonDemo.sum();
        });
        t1.start();
        t1.join();

        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
