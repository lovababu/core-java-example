package org.avol.java11.features.Predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Lovababu P.
 * DateTime: 09-05-2022
 * Project Name: java11feataures
 **/
public class PredicateEx {
    public static void main(String[] args) {
        List<String> l = List.of("Hello", "World", "");
        //Predicate.not(function) added in Java 11.
        List<String> nonEmptyList = l.stream().filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        System.out.println(nonEmptyList);
    }
}
