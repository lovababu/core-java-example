package org.avol.jdk9.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Executor is capable of submitting the task after the delay.
 */
public class ExecutorWithDelay {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Executor executors = CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS);
        executors.execute(() -> System.out.println("Hello, World.")); //this is will executed after 2 seconds.
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
