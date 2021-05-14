package org.avol.jdk9.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Lovababu P.
 * DateTime: 14-05-2021
 * Project Name: java-features
 **/
public class CompletableFutureTimeout {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 56;
        });

        future.thenAccept(System.out::println);
        //future.orTimeout()  //added in 9 to timeout the thread.
        //future.copy()
        future.completeOnTimeout(-1, 1, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(2);
    }
}
