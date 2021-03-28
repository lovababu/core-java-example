package org.avol.jdk9.diamondoperator;

/**
 * diamond operator enhancements.
 *
 */
public class DiamondOperatorEnhancements {

    interface MyClass<T> {
        T toLower(T t);
    }

    public static void main(String[] args) {

        //doesn't compile in below jDK 9. reason: cannot use '<>' with anonymous inner classes
        MyClass myClass = new MyClass<String>() {
            @Override
            public String toLower(String o) {
                return o.toLowerCase();
            }
        };

        System.out.println(myClass.toLower("HELLO"));
    }
}
