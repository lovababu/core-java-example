# Java 9 Features.

## Java Modules.
Multi module java projects, and dynamically load modules in other module.
## Collections.
Immutable collection objects using static method of(...)
## Diamond Operator.
Diamond operator issue while creating anonymous class solved.
## Try with resources.
We can refer object created outside the try block in try block to safely close the resource.
## Streams.
takeWhile(), dropWhile() and ofNullable() methods introduced in streams.
## Private methods in Interface.
Method can be marked as private in interface.
## NIO.
java.concurrent.Flow interface, and other classes to support pub/sub messaging.

## Optional
  or, ifPresentElse, inject new optional.

## JShell REPL for Java.
  Command line to execute the java code instead of creating class and verbose code.
  / commands to jshell
  2 + 3, output = 5
  /v, /edit, /drop, /!, /imports, /list,/save,/history
## Modules project jigsaw (https://www.oracle.com/corporate/features/understanding-java-9-modules.html).
Modularity adds a higher level of aggregation above packages.
Module is a uniquely named, reusable group of related packages, as well as resources.
 - Module Name.
 - Module Dependencies.
 - The packages it explicitly makes available to other modules.
 - The services it offers (exports, open, opens).
 - The services it consumes (requires).
 - To what other modules it allows reflection.
module-info.java -> exports, requires, open, opens, uses, provides with, 
Java is older language, and multiple devices using the java. Monolithic architecture and tighly coupled.
Modularity proposed in 2005 for Java 7, but it came to realty with java 9 in 2017.
Goals.
 - Reliable configuration.
 - Strong encapsulation.
    - Reflection doesn't work.
 - Scalable Java platform.
 - Greater Platform integrity.
 - Improved performance.

Unnamed modules.
System modules
Application modules.
Automatic modules
Explicit modules

Commands.
 - java --list-modules | wc -l

classpath vs modulepath
to find the module name:-  jar -f <path>.jar -d
ServiceLoader API:
   - Inversion of control.
Targeted Linking: jlink



