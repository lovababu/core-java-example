package org.avol.java11.features.collections;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Lovababu P.
 * DateTime: 09-05-2022
 * Project Name: java11feataures
 **/
public class CollectionsEx {
    public static void main(String[] args) {
        List<Integer> intColl = new ArrayList<>();
        intColl.add(10);
        //toArray(IntFunction)
        Integer[] copyColl = intColl.toArray(Integer[]::new);  //this doesn't work in jdk 8.
        System.out.println(copyColl[0]);
    }
}
