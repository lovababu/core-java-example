package org.avol.jdk15.collection;

import java.util.Map;

public class TreeMap {

    public static void main(String[] args) {
        Map<String, String> treeMap = new java.util.TreeMap<>();
        treeMap.put("Name", "Charlie");
        treeMap.put("Address", "Bangalore");

        // specialized implementation provided for 'putIfAbsent' method in TreeMap.java,
        // instead of referring default implementation from 1.8 Map.
        treeMap.putIfAbsent("Age", "35");

        // specialized implementation provided for 'computeIfAbsent' method in TreeMap.java,
        // instead of referring default implementation from 1.8 Map.
        treeMap.computeIfAbsent("Address", String::toUpperCase);

        // specialized implementation provided for 'computeIfAbsent' method in TreeMap.java,
        // instead of referring default implementation from 1.8 Map.
        treeMap.computeIfPresent("Address", (s, s2) -> s2.toUpperCase());

        // specialized implementation provided for 'compute' method in TreeMap.java,
        // instead of referring default implementation from 1.8 Map.
        treeMap.compute("Name", (s, s2) -> s2.toLowerCase());  //it may produce NPE, hence recommend to use computeIfPresent.

        // specialized implementation provided for 'merge' method in TreeMap.java,
        // instead of referring default implementation from 1.8 Map.
        treeMap.merge("Address", ", Whitefield.", (s, s2) -> s + s2);


        System.out.print(treeMap);
    }
}
