# JDK 11 Features.

for more details refer https://www.oracle.com/java/technologies/javase/11-relnote-issues.html#Important_Changes

## Unicode and Script support
Unicode version 10.0.0 supported http://unicode.org/versions/Unicode10.0.0/

## Standard HTTP Client.
The HTTP Client has been standardized in Java 11. Incubator project moved to java.net.http.

## Collection new methods.
A new default method toArray(IntFunction) has been added to the java.util.Collection interface.  
This method allows the collection's elements to be transferred to a newly created array of a desired runtime type. The new method is an overload of the existing toArray(T[]) method that takes an array instance as an argument. 

## String method to split new line character as array.
New method String#lines() introduced to split the string by new line character.

## Introduced new static method to write/read string to/from file.
Files.writeString(Path, charSequence) static method to write string to file.  
Files.readString(Path) static method to read string from file.

## Predicate method.
Introduced Predicate.not(function) method to negate the condition.

## Local variable declaration in lambda function.
We can now declare the Lambda function local variable type.

## Nestmate class type checking.

## java command to run the .java directly.
/> Hello.java   -- prints output, no need javac .class file.
