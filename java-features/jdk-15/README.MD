# JDK 15 Features.

## java.lang.CharSequence
[Refer](/src/org/avol/jdk15/lang)

isEmpty() added to interface with default implementation. isEmpty() part of java.lang.String from JDK 1.6.

## java.util.TreeMap
[Refer](/src/org/avol/jdk15/collection)

From JDK 15, TreeMap has its own implementation for below methods to have better performance than default implementation exist in java.util.Map interface.
    
    putIfAbsent()   
    computeIfAbsent()   
    computeIfPresent()   
    compute()   
    merge()
    
## JMX Third Port configuration.
[Refer](https://www.oracle.com/java/technologies/javase/15-relnote-issues.html#JDK-8234484)

JMX supports (explicit) remote network access through the configuration of two network ports (either from the command line or in a property file), by setting the following properties:
    
    com.sun.management.jmxremote.port=<port#>
    com.sun.management.jmxremote.rmi.port=<port#>

This port previously had its number selected at random, which could cause port collisions.
However, it is now possible to configure the third JMX port (local only) by using:
    
    com.sun.management.jmxremote.local.port=<port#>

## String as Text Blocks without escape characters.
[Refer](/src/org/avol/jdk15/textblocks)

_Using "one-dimensional" string literals_

    ```
    String query = "SELECT \"EMP_ID\", \"LAST_NAME\" FROM \"EMPLOYEE_TB\"\n" +
                   "WHERE \"CITY\" = 'INDIANAPOLIS'\n" +
                   "ORDER BY \"EMP_ID\", \"LAST_NAME\";\n";
    ```

_Using a "two-dimensional" block of text_

    ```
    String query = """
                   SELECT "EMP_ID", "LAST_NAME" FROM "EMPLOYEE_TB"
                   WHERE "CITY" = 'INDIANAPOLIS'
                   ORDER BY "EMP_ID", "LAST_NAME";
                   """
    ```
    
## Record classes.
[Refer](src/org/avol/jdk15/record)

The record is a new type of class in Java that makes it easy to create immutable data objects.
All Arg constructor and property methods auto generated in compiled classes.

## Sealed Classes.
[Refer](src/org/avol/jdk15/sealed)

Sealed classes to restrict other classes to extending from. 
Permitted classes must be declared as either final or sealed.

## Hidden Classes.
[Refer](https://www.baeldung.com/java-hidden-classes)

Mostly used in framework/library implementation to hide the classes and create instances dynamically.
Hidden classes are classes that cannot be used directly by the bytecode or other classes
Characteristics of Hidden classes,

    Non-Discovarable.
    Access Control
    Limited Life Cycle

## Pattern Matching Type checks.

Variable declaration and binding in single statement, while checking type itself.

    ```
        Animal a = new Dog();

        if (a instanceof Dog) {
            Dog d = (Dog) a;  //additional declaration and assignment.
            d.toString();
        }

        if (a instanceof Dog d) {  //from v15, declaration and assignment in pattern matching itself.
            d.toString();
        }
    ```

