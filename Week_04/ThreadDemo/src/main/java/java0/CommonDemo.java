package java0;

public class CommonDemo {

     public static int sum() {
        System.out.println("Thread End...");
        return fibo(36);
    }

    public static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
