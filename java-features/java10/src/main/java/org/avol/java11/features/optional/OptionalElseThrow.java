package org.avol.java11.features.optional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author Lovababu P.
 * DateTime: 05-05-2022
 * Project Name: java10features
 **/
public class OptionalElseThrow {

    public static void main(String[] args) {
        List<Integer> list = List.of(10, 25, 34, 31, 58);
        final Optional<Integer> divideBy13 = list.stream()
                .filter(integer -> (integer % 13) == 0).findFirst();
        try {
            divideBy13.orElseThrow(); //added in Java 10.
        } catch (NoSuchElementException nes) {
            System.out.printf(nes.getMessage()); //prints: No value present
        }
    }
}
