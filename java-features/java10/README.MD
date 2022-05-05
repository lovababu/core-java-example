# Java 10 Features in detail with Example.

https://www.oracle.com/java/technologies/javase/10-relnote-issues.html

## Optional Enhancements.
A new method orElseThrow has been added to the Optional class. It is synonymous with and is now the preferred alternative to the existing get method.  
Refer package optional.

## Collections new methods.  
The List.copyOf, Set.copyOf, and Map.copyOf methods create new collection instances from existing instances. New methods toUnmodifiableList, toUnmodifiableSet, and toUnmodifiableMap have been added to the Collectors class in the Stream package. These allow the elements of a Stream to be collected into an unmodifiable collection.  
Refer package collections

## System Properties new
A new system property jdk.disableLastUsageTracking has been introduced to disable JRE last usage tracking for a running VM.  

## Security
The clear passwords present in the jmxremote.password file are now being over-written with their SHA3-512 hash by the JMX agent.  

## GC improvements
Improved G1 GC worst case latencies by making the full GC Parallel.

## Byte code generation for Enhanced loop
Declares the iterator variable outside of the for loop allows a null to be assigned to it as soon as it is not longer used. This makes it 
accessible to the GC.

## Remove Runtime.class methods.
The methods Runtime.getLocalizedInputStream and Runtime.getLocalizedOutputStream have been removed. 
