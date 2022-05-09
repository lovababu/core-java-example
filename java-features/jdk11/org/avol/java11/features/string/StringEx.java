package org.avol.java11.features.string;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lovababu P.
 * DateTime: 09-05-2022
 * Project Name: java11feataures
 **/
public class StringEx {
    public static void main(String[] args) {
        String lineString = "Hello World! \n Here is java 11 String.lines() method";
        //introduced in java 11, split the string by newline characters.
        List<String> lines = lineString.lines()
                .collect(Collectors.toList());
        System.out.println(lines);
    }
}
