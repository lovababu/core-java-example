package org.avol.jdk9.optional;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lovababu P.
 * DateTime: 14-05-2021
 * Project Name: java-features
 **/
public class OptionalImprovements {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(12, 43, 21, 65, 9, 2, 4, 6);
        java.util.Optional<Integer> first = integers.stream()
                .filter(integer -> integer > 85)
                .findFirst();

        first.ifPresentOrElse(integer -> System.out.println("Number found: " + integer), () -> {
            System.out.println("Number Not Found.");
        });

        //first.or(() -> Optional.of(0)); //9 to inject new optional value.
        first.stream();  // to convert the optional 0/1 value into stream.
    }
}
