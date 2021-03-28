package org.avol.jdk9.streams;

import java.util.PrimitiveIterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * takeWhile(predicate)
 * dropWhile(predicate)
 * iterate() static method.
 * Stream.ofNullable(), create a nullable stream.
 */
public class StreamsEnhancements {

    public static void main(String[] args) {
        System.out.println("----- Take While -----");
        IntStream intStream1 = IntStream.of(10, 20, 30, 40, 50, 60, 15, 25, 35, 45, 55, 65);

        //takeWhile, takes until predicate success and stop consuming messages.
        intStream1.takeWhile(value -> value < 25).forEach(System.out::println); //o/p: 10, 20
        System.out.println("----- Drop While -----");
        IntStream intStream2 = IntStream.of(10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65);
        //dropWhile
        intStream2.dropWhile(value -> value < 20).forEach(System.out::println); //20 to 65
        System.out.println("----- iterate() static method -----");
        //iterator(), static method to create primitive iterator.
        IntStream intStream3 = IntStream.of(10, 20, 30);
        PrimitiveIterator.OfInt iterator = intStream3.iterator();
        while (iterator.hasNext()) {
            System.out.println("Next  -> " + iterator.next());
        }
        System.out.println("----- ofNullable -----");
        //ofNullable, method to avoid NPE by creating a stream with null.
        Stream<Object> nullStream = Stream.ofNullable(null);
        nullStream.forEach(System.out::println); //nothing will printed.
    }
}
