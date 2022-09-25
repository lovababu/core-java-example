package org.avol.jdk15.pattern;

import org.avol.jdk15.sealed.Animal;
import org.avol.jdk15.sealed.Dog;

public class PatternMatching {

    public static void main(String[] args) {
        Animal a = new Dog();

        if (a instanceof Dog) {
            Dog d = (Dog) a;  //additional declaration and assignment.
            d.toString();
        }

        if (a instanceof Dog d) {  //from v15, declaration and assignment in pattern matching itself.
            d.toString();
        }
    }
}
