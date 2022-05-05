package org.avol.java11.features.collections;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lovababu P.
 * DateTime: 05-05-2022
 * Project Name: java10features
 **/
public class CollectionsCopyOf {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 34, 34, 54, 90); //creates unmodifiable list.
        //copyOf() to create a copy of existing collection.
        List<Integer> listCopy = List.copyOf(list); //copyOf introduced in 10, returns again unmodifiable list.
        //Set.copyOf(), Map.copyOf() - can be used for set and map.

        //toUnmodifiableCollection from stream.
        List<Integer> modifiableList = list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList()); //returns modifiable list.
        modifiableList.add(13);
        System.out.println(modifiableList);  // No error, it works.

        //what if we want to produce unmodifiable collection from stream.
        List<Integer> unModifiableList = list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toUnmodifiableList()); //returns modifiable list.
        unModifiableList.add(13); //This line throws error.
        //Collectors#toUnModifiableSet(), toUnmodifiableMap() for creating immutable set and map from stream.
    }
}
