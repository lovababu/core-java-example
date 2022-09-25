package org.avol.jdk15.sealed;

//Animal is a sealed class, only Dog and Cat classes extending from Animal.
public abstract sealed class Animal permits Dog, Cat {
    //properties and methods.
}
