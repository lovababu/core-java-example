package org.avol.jdk15.lang;

public class CharSequence {

    public static void main(String[] args) {
        String str = "Avol";
        // method is existed in String.java class from 1.6 onwards,
        // but not added to interface CharSequence.java due to contract obligations.
        // In JDK 15, isEmpty added to interface as default.
        // https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8215401
        boolean isEmpty = str.isEmpty();
    }
}
