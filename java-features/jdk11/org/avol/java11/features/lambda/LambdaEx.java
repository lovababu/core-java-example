package org.avol.java11.features.lambda;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lovababu P.
 * DateTime: 09-05-2022
 * Project Name: java11feataures
 **/
public class LambdaEx {
    public static void main(String[] args) {
        List<String> l = List.of("Lova", "Java");
        //local variable type declaration in lamdba functions.
        String resultString = l.stream()
                .map((var x) -> x.toUpperCase())  //Lambda local variable type not support below java 11.
                .collect(Collectors.joining(", "));
        assert resultString.equals("LOVA, JAVA");
    }
}
