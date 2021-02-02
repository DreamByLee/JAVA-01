package java0;

import java.util.concurrent.*;

/**
 * @author Leeyj
 * @date 2021/2/1 21:39
 */
public class Demo04_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();

        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> result = es.submit(CommonDemo::sum);
        es.shutdown();

        System.out.println("异步计算结果为："+result.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }

}
