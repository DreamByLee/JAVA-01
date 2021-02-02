package java0;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Leeyj
 * @date 2021/2/2 19:40
 */
public class Demo08_FutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start=System.currentTimeMillis();

        FutureTask<Integer> futureTask = new FutureTask<>(CommonDemo::sum);

        new Thread(futureTask).start();

        System.out.println("异步计算结果为："+futureTask.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");


    }
}
