package org.avol.jdk9.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * List.of(...)/Set.of(...)/Map.of(...) to create immutable data structure in java.
 *
 *
 */
public class NewInCollections {

    public static void main(String[] args) {

        //It is known, that List/Set/Map created through new operator are mutable objects.
        //To create immutable Collection object, until JDK 8 we should use Collections.unmodifiableXXX() methods.

        List<String> j8ImmutableList = Collections.unmodifiableList(new ArrayList<>());
        j8ImmutableList.add("Hello");  //it results error, because j8ImmutableList cannot be modified.

        //in Jdk 9, no more verbose pretty much in single line we can create using static/factory methods on respective collection interfaces.

        List<String> j9ImmutableList = List.of("Hello", "World"); //static methods List.of(...) is new in JDK 9.
        j9ImmutableList.add("Welcome."); //it results error because j9ImmutableList cannot be modified.

        //similarly sets/maps too.
        Set<String> j9ImmutableSet = Set.of("Hello", "World"); //immutable Set.

        Map<String, String> j9ImmutableMap = Map.of("Key1", "Value1", "Key2", "Value2"); //Immutable Map.
    }
}
