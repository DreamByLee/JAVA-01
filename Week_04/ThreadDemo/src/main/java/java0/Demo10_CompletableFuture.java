package java0;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Leeyj
 * @date 2021/2/2 19:52
 */
public class Demo10_CompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start=System.currentTimeMillis();
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(CommonDemo::sum);

        System.out.println("异步计算结果为："+cf.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");


    }
}
