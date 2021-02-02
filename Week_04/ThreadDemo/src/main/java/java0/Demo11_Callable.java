package java0;

import java.util.concurrent.Callable;

/**
 * @author Leeyj
 * @date 2021/2/2 19:55
 */
public class Demo11_Callable {

    public static void main(String[] args) throws Exception {

        long start=System.currentTimeMillis();

        Callable<Integer> callable = CommonDemo::sum;

        System.out.println("异步计算结果为："+callable.call());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
