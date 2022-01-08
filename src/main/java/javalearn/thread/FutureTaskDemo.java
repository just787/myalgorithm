package javalearn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 多线程任务测试
 *
 * @author wuduolin
 * @version $Id: FutureTaskDemo.java, v 0.1 2022年01月08日 4:31 PM wuduolin Exp $
 */
public class FutureTaskDemo {
    /**
     * 线程池
     */
    private static ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(3,
            10,
            1L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100),
            new ThreadFactory() {
                AtomicInteger atomicInteger = new AtomicInteger();

                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setName("myThread-" + atomicInteger.incrementAndGet());
                    return thread;
                }
            });


    static Callable<String> getCallable(Integer i) {
        Callable<String> callable = () -> {
            String str = "callable : " + i;
            System.out.println(str);
            if (i == 3) {
                System.out.println("*** sleep *** " + str);
                Thread.sleep(5000L);
            }
            return str;
        };
        return callable;
    }

    static Runnable getRunnable(Integer i) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String str = "runnable : " + i;
                System.out.println(str);
                if (i == 3) {
                    System.out.println("*** sleep *** " + str);
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        return runnable;
    }

    static void testCallable() {
        System.out.println(" ====  testCallable start ====");

        List<Future<String>> futures = new ArrayList<>();
        IntStream.rangeClosed(0, 10).forEach(i -> {
            Callable<String> callable = getCallable(i);
            futures.add(taskExecutor.submit(callable));
        });

        futures.forEach(future -> {
            try {
                // future.get() 方法会按futures里线程的顺序阻塞，直到所有线程执行完毕
                System.out.println("get >> " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.out.println(" ====  testCallable end ====");
    }

    static void testRunnable() {
        System.out.println(" ====  testRunnable start ====");

        IntStream.rangeClosed(0, 10).forEach(i -> {
            Runnable runnable = getRunnable(i);
            taskExecutor.execute(runnable);
        });

        System.out.println(" ====  testRunnable end ====");
    }

    public static void main(String[] args) {
        testCallable();
        //testRunnable();
    }
}